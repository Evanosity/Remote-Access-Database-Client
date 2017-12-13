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
	 * public void sendMessage - this method will send a message to the server.
	 * @param toSend - the message to send.
	 * @throws IOException
	 */
	public void sendMessage(String toSend)throws IOException{
		send.writeUTF(toSend);
	}
	
	/**
	 * public void shutdown - closes the connection in a graceful fashion.
	 * @throws IOException
	 */
	public void shutdown()throws IOException{
		client.close();
	}
}
