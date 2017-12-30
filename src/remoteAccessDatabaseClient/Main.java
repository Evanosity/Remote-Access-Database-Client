package remoteAccessDatabaseClient;

import java.io.IOException;

public class Main {
	
	private static String tableContents;
	
	public static void main(String[] args) throws IOException {
		ClientSide csl = new ClientSide();
		csl.ClientSideLogin();
		
		NetworkClient nc=new NetworkClient("192.168.0.100",6066);
		
		nc.receiveMessage();
	}
}
