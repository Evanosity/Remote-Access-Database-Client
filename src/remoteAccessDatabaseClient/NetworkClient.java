package remoteAccessDatabaseClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * public class NetworkClient - this is the framework for networking, and it just has the very basic receive/send methods. These will be used
 * by other classes to effectively send and receive data.
 * @author Evanosity
 * @date December 11 2017
 */
public class NetworkClient {
	private Socket client;
	
	private DataInputStream receive;
	private DataOutputStream send;
	
	private int port;
	private String host;
	
	/**
	 * public NetworkClient - this is the constructor that sets up the class.
	 * @param portNumber - the port to connect on
	 * @param hostName - the host to connect to
	 */
	public NetworkClient(String hostName, int portNumber){
		port=portNumber;
		host=hostName;
		
		try{
			client=new Socket(host, port);
			System.out.println("Connection complete");
			
			send=new DataOutputStream(client.getOutputStream());
			receive=new DataInputStream(client.getInputStream());
		}
		catch(IOException e){
			System.out.println("Server not on?");
		}
	}
	
	/**
	 * public String receiveMessage - this method will read an input from the server, then return it.
	 * @return the received message
	 * @throws IOException
	 */
	public String receiveMessage()throws IOException{
		return receive.readUTF();
	}
	
	/**
	 * public String[][][] receiveSuperArray - this method will receive a 3d array from the client 
	 * @param x - the size of the first array
	 * @param y - the size of the second array
	 * @param z - this size of the third array
	 * @return toReturn - the organized 3d array
	 * @throws IOException
	 */
	public String[][][] receiveSuperArray(int x, int y, int z)throws IOException{
		String[][][]toReturn=new String[x][y][z];
		String[]unorganized=new String[x*y*z];
		int a=0;
		
		//this loop will simply collect all the information and then immediately store it.
		for(int i=0; i!=toReturn.length; i++){
			for(int k=0; k!=toReturn[i].length;k++){
				for(int l=0; l!=toReturn[i][k].length;l++){
					a++;
					unorganized[a]=receive.readUTF();
				}
			}
		}
		
		//this loop will evaluate all of the information we received and organize it appropriately.
		for(int i=0; i!=unorganized.length; i++){
			int xe;
			int ye;
			int ze;
			
			xe=Integer.parseInt(unorganized[i].substring(0, unorganized[i].indexOf(":")));
			unorganized[i]=unorganized[i].substring(unorganized[i].indexOf(":")+1,unorganized[i].length());
			
			ye=Integer.parseInt(unorganized[i].substring(0, unorganized[i].indexOf(":")));
			unorganized[i]=unorganized[i].substring(unorganized[i].indexOf(":")+1,unorganized[i].length());
			
			ze=Integer.parseInt(unorganized[i].substring(0, unorganized[i].indexOf(":")));
			unorganized[i]=unorganized[i].substring(unorganized[i].indexOf(":")+1,unorganized[i].length());
			
			toReturn[xe][ye][ze]=unorganized[i];
		}
		
		return toReturn;
	}
	
	/**
	 * public void sendMessage - this method will send a message to the server.
	 * @param toSend - the message to send.
	 * @throws IOException
	 */
	public void sendMessage(String toSend)throws IOException{
		send.writeUTF(toSend);
	}
	
	/**
	 * public void sendArray - this method sends a 1d string array to the server.
	 * @param toSend - string array to send
	 * @throws IOException
	 */
	public void sendArray(String[] toSend)throws IOException{
		for(int i=0; i!=toSend.length; i++){
			send.writeUTF(toSend[i]);
		}
	}
	
	/**
	 * public void sendSuperArray - this method will send a 3d array over the network. It's a bit convoluted but it works.
	 * @param toSend - this is the 3d to send.
	 * @throws IOException
	 */
	public void sendSuperArray(String[][][]toSend)throws IOException{
		int fullLength=0;

		//this loop will read the size of the array. This is important, as the client needs to prepare for the volume of information we are sending.
		for(int i=0; i!=toSend.length; i++){
			for(int k=0; k!=toSend[i].length;k++){
				for(int l=0; l!=toSend[i][k].length;l++){
					fullLength++;
				}
			}
		}
		send.writeUTF("messagelength:"+fullLength);
		
		//This loop will actually send each piece of information. However, it also adds an array ID string to each one of the messages.
		//This is so that if the packets for some reason don't arrive in the proper order, the receiver can piece it back together.
		for(int i=0; i!=toSend.length; i++){
			for(int k=0; k!=toSend[i].length;k++){
				for(int l=0; l!=toSend[i][k].length;l++){
					send.writeUTF(i+":"+k+":"+l+":"+toSend[i][k][l]);
				}
			}
		}
	}
	
	/**
	 * public void shutdown - closes the connection in a graceful fashion.
	 * @throws IOException
	 */
	public void shutdown()throws IOException{
		client.close();
	}
}
