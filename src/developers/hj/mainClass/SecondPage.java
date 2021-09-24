package developers.hj.mainClass;

import developers.hj.Controller.SController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecondPage {
	public void adminWorkspace() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/AdminSPage.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		SController ctl = loader.getController();
		ctl.setRoot(root);
		
		adminStage.setTitle("관리자 페이지");
		adminStage.setScene(scene);
		adminStage.show();

	}


	

}
