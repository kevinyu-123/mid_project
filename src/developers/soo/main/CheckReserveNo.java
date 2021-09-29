package developers.soo.main;

import java.io.IOException;

import developers.soo.Controller.ReserveController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckReserveNo {
	public void check() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/soo/fxml/CheckResvno.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		ReserveController ctl = loader.getController();
		ctl.setRoot(root);
		stage.setScene(scene);
		stage.show();
	}
}
