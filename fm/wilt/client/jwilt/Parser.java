package fm.wilt.client.jwilt;

import org.json.simple.parser.JSONParser;

public class Parser {
	// TODO: Messing around with a concept - need to come back to this
	
	private static JSONParser instance = null;
	
	public Parser() { }
	
	public static JSONParser getInstance() {
		if (instance == null) {
			instance = new JSONParser();
		}
		return instance;
	}
}
