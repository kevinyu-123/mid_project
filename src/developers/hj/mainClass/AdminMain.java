package developers.hj.mainClass;

import developers.hj.Controller.FController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminMain {
	public void adinLogin() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/AdminFPage.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(root);
		FController ctl = loader.getController();
		ctl.setRoot(root);
		
		adminStage.setTitle("관리자 로그인");
		adminStage.setScene(scene);
		adminStage.show();

	}
}
