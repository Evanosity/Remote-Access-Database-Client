package remoteAccessDatabaseClient;

<<<<<<< HEAD
import java.io.IOException;

public class Main {
	/**
	 * todo
	 * -add the method for properly receiving arrays
	 * -hook up the editor thingy for the database contents on the GUI. Should be simple
	 * -Properly flag which stuff needs to be updated/added/deleted/whatever to the database
	 */
	private static String tableContents;
	
	public static void main(String[] args) throws IOException {
		ClientSide csl = new ClientSide();
		csl.ClientSideLogin();
		
		NetworkClient nc=new NetworkClient("192.168.0.100",6066);
		
		nc.receiveMessage();
	}
	
	public static void pass(String[][][]from){
=======
public class Main {
	
	private static ClientSide csl;
	private static NetworkClient nc;
	
	public static void main(String[] args) {
		csl = new ClientSide();
		csl.ClientSideLogin();
		nc = new NetworkClient("192.168.0.0", 6066);
>>>>>>> SubC
		
	}
}
