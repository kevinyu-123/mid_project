package mainMovie;

import db.DBService;
import dto.MovieDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMovie extends Application {
	DBService db = new DBService();
	MovieDTO dto = db.selectSQL(null) ;
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMovie.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		MainController ctl = loader.getController();
		ctl.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
