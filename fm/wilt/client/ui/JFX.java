package fm.wilt.client.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JFX extends Application {

	public void start(Stage primaryStage) throws Exception {
		Parent loginForm = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(loginForm);
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
	public static void switchScenes(Parent newScene, String title) throws IOException {
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(newScene));
		stage.show();
	}
	
	public void launchJfx(String[] args) {
		launch(args);
	}
	
}
