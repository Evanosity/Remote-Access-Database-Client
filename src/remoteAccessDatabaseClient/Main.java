package remoteAccessDatabaseClient;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//ClientSide csl = new ClientSide();
		//csl.ClientSideLogin();
		NetworkClient nc=new NetworkClient("192.168.0.100",6066);
		nc.sendMessage("testing 1 2 3 testing");
	}
}
