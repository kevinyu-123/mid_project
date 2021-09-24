package developers.hj.mainClass.resv;

import developers.hj.Controller.ResvController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResvMenu {
	public void showMenu() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/ReservationMenu.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		ResvController ctl = loader.getController();
		ctl.setRoot(root);
		
		adminStage.setTitle("회원 예매 정보 보기");
		adminStage.setScene(scene);
		adminStage.show();
	}

}
