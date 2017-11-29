package remoteAccessDatabaseClient;

/**
 * public class Parser - this class will take the massive (and potentially scrambled data output) from the server and recompile it into a usable array.
 * @author Evanosity
 * @date November 29 2017
 */
public class Parser {
	public Parser(){
		/**
		 * okay so
		 * this is how it's gonna go.
		 * One message in the front, saying the array size. Networking class will then prepare to receive that many messages, and this class will create an array of this size.
		 * As the packets come in, the array will recompile it based off of the info at the start of each packet.
		 * 
		 * As well, there is a chance we will need to receive a list of all of the column headers. However, I think it would be easier to store that locally.
		 *
		 * String message="1|2|3|<data here>
		 */
	}
}
