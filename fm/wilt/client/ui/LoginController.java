package fm.wilt.client.ui;

import fm.wilt.client.jwilt.Api;
import fm.wilt.client.ui.JFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginController {

	@FXML private Button loginBtn;
	@FXML private TextField username;
	@FXML private TextField password;


	public void Login(ActionEvent event) {
		Api.getInstance().login(getUsername(), getPassword());
		try {
			JFX.switchScenes(FXMLLoader.load(getClass().getResource("Scrobble.fxml")), "Scrobble");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns entered input from username text-field
	 * @return username
	 */
	public String getUsername() {
		return username.getText();
	}

	/**
	 * Sets username textfield content
	 * @param newUser
	 */
	public void setUsername(String newUser) {
		username.setText(newUser);
	}
	
	/**
	 * Returns entered input from password pw-field
	 * @return password
	 */
	public String getPassword() {
		return password.getText();
	}
	
	/**
	 * Sets password pwfield's content
	 * @param newPass
	 */
	public void setPassword(String newPass) {
		password.setText(newPass);
	}
}
