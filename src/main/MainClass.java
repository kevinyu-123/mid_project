package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		arg0.setScene(new Scene(root));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
