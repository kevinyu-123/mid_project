package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import developers.soo.service.ReserveImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ReserveController implements Initializable {
	ReserveImpl ri;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		ri.setRoot(root);
	}
	
	public void showInfo() {
		ri.showInfo();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		ri = new ReserveImpl();
	}

}
