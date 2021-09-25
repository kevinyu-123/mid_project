package developers.hj.mainClass.resv;

import developers.hj.Controller.ResvController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindDelMem {
	public void delMemSearch() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/findDelResvInfo.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		ResvController ctl = loader.getController();
		ctl.setRoot(root);
		adminStage.setTitle("예매 내역 찾기");
		adminStage.setScene(scene);
		adminStage.show();

	}
}
