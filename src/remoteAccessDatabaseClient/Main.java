package remoteAccessDatabaseClient;

public class Main {
	
	private static ClientSide csl;
	private static NetworkClient nc;
	
	public static void main(String[] args) {
		csl = new ClientSide();
		csl.ClientSideLogin();
		nc = new NetworkClient("192.168.0.0", 6066);
		
	}

}
