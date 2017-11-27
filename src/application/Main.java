package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/paintjava/gui/MainFrame.fxml"))));
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
