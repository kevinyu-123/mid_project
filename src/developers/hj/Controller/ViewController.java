package developers.hj.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import db.DBCommon;
import developers.hj.service.AdminService;
import developers.hj.service.AdminServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ViewController implements Initializable {
	Parent root;
	AdminService as;
	
	public void setRoot(Parent root) {
		this.root = root;
		as.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		as = new AdminServiceImpl();
		DBCommon.setDBConnection();
	}
	public void viewOneMem() {
		as.viewOneMem();
	}
	public void viewAllMem() {
		as.viewAllMem();
	}
	public void find() {
		as.find();
	}
}
