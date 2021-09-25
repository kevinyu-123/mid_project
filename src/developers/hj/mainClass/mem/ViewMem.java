package developers.hj.mainClass.mem;


import developers.hj.Controller.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewMem {
	public void select() {
		Stage adminStage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/viewMem.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		ViewController ctl = loader.getController();
		ctl.setRoot(root);
		adminStage.setTitle("회원보기");
		adminStage.setScene(scene);
		adminStage.show();

	}
	
}
