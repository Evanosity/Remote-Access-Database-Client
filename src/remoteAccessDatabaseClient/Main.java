package remoteAccessDatabaseClient;

import java.io.IOException;

/**
 * public class Main - run this to trigger everything
 * @author Evanosity
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ClientSide csl = new ClientSide();
		csl.ClientSideLogin();
	}
}
