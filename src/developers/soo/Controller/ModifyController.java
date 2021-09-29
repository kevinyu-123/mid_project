package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import developers.soo.service.ModifyImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ModifyController implements Initializable {
	ModifyImpl modi;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		modi.setRoot(root);
	}
	
	public void onModify() {
		modi.modify();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		modi = new ModifyImpl();
	}

}
