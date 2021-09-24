package developers.hj.mainClass.movie;

import developers.hj.Controller.MovieController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddMovie {
	public void setMovie() {
	
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/SetMovie.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		MovieController ctl = loader.getController();
		ctl.setRoot(root);
		Button button = (Button)root.lookup("#close");
		
		adminStage.setTitle("영화 정보 입력");
		adminStage.setScene(scene);
		adminStage.show();
		button.setOnMouseClicked(e ->{
			adminStage.close();
		});

	}
}
