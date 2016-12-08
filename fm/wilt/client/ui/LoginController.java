package fm.wilt.client.ui;

import javafx.event.ActionEvent;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import fm.wilt.client.jwilt.Api;
import fm.wilt.client.jwilt.Parser;


public class LoginController {
	@FXML
	private Button loginBtn;
	private Parser parser = new Parser();

	Api Backend = new Api();

	public void Login(ActionEvent event) throws ParseException {
		Backend.login("Modal", "password");
		Backend.postScrobble("Test from Java!", "JAVA:D");
	}
}
