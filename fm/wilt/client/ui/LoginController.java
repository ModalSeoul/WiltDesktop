package fm.wilt.client.ui;

import fm.wilt.client.jwilt.Api;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginController {

	@FXML private Button loginBtn;
	@FXML private TextField username;
	@FXML private TextField password;

	Api Backend = new Api();

	public void Login(ActionEvent event) {
		Backend.login(getUsername(), getPassword());
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
