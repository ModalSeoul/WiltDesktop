package fm.wilt.client.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JFX extends Application {

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
	public void launchJfx(String[] args) {
		launch(args);
	}
	
}
