package developers.hj.mainClass.mem;

import developers.hj.Controller.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindMem {
	public void search() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/findMem.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		ViewController ctl = loader.getController();
		ctl.setRoot(root);
		adminStage.setTitle("찾기");
		adminStage.setScene(scene);
		adminStage.show();

	}
	
}
