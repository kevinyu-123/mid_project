package developers.soo.main;

import java.io.IOException;

import developers.soo.Controller.MyPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyPageMain {
	public void myPage() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/soo/fxml/MyPage.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		MyPageController ctl = loader.getController();
		ctl.setRoot(root);
		stage.setScene(scene);
		stage.show();
	}
}
