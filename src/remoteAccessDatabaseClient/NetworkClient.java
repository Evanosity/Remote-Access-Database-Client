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
	 * public String[][] receiveDoubleArray - this method will receive a 2d array over a socket. 
	 * @return
	 * @throws IOException
	 */
	public String[][] receiveDoubleArray()throws IOException{
		String size=receive.readUTF();
		int x=Integer.parseInt(size.substring(0, size.lastIndexOf(":")));
		int y=Integer.parseInt(size.substring(size.indexOf(":")+1, size.length()));
		
		String[][]toReturn=new String[x][y];
		
		for(int i=0;i!=x;i++){
			for(int f=0;f!=y;f++){
				toReturn[i][f]=receive.readUTF();
				System.out.println("Receiving: "+toReturn[i][f]);
			}
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
	 * public void sendDoubleArray - this method sends a 2d array over the socket.
	 * @param toSend - this is the array to send.
	 * @throws IOException
	 */
	public void sendDoubleArray(String[][]toSend)throws IOException{
		int x=toSend.length;
		int y=toSend[0].length;
		send.writeUTF(toSend.length+":"+toSend[0].length);
		
		for(int i=0;i!=x;i++){
			for(int f=0;f!=y;f++){
				send.writeUTF(i+":"+f+":"+toSend[i][f]);
				System.out.println("Sending: "+toSend[i][f]);
			}
		}
	}
	
	public boolean isConnected(){
		if(client.isConnected()){
			return true;
		}
		return false;
	}
	
	/**
	 * public void shutdown - closes the connection in a graceful fashion.
	 * @throws IOException
	 */
	public void shutdown()throws IOException{
		client.close();
	}
}
