package developers.hj.mainClass.movie;

import developers.hj.Controller.MovieController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindMovName {
	public void findName() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/FindMovie.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		MovieController ctl = loader.getController();
		ctl.setRoot(root);
		
		adminStage.setTitle("영화 이름 입력");
		adminStage.setScene(scene);
		adminStage.show();

	}

}
