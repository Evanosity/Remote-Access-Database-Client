package remoteAccessDatabaseClient;

/**
 * public class Parser - this class will take the massive (and potentially scrambled data output) from the server and recompile it into a usable array.
 * @author Evanosity
 * @date November 29 2017
 */
/**
 * okay so
 * this is how it's gonna go.
 * One message in the front, saying the array size. Networking class will then prepare to receive that many messages, and this class will create an array of this size.
 * As the packets come in, the array will recompile it based off of the info at the start of each packet.
 * 
 * As well, there is a chance we will need to receive a list of all of the column headers. However, I think it would be easier to store that locally.
 *
 * String message="1|2|3|<data here>"
 */
public class Parser {
	//there is actually a good chance this class might need to be mirrored on the server side; however, as of right now I am unsure how the database access is being done.
	private String[][]raw;
	private String[][]toReturn;
	public Parser(String[][] given){
		raw=given;
	}
	
	public String[][]getArray(){
		formatArray();
		return toReturn;
	}
	
	private void formatArray(){
		toReturn=raw;
	}
}
