package developers.hj.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import db.DBCommon;
import developers.hj.service.AdminService;
import developers.hj.service.AdminServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class ResvController implements Initializable {
	Parent root;
	AdminService as;
	
	public void setRoot(Parent root) {
		this.root = root;
		as.setRoot(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		as = new AdminServiceImpl();
	}
	public void findViewId() {
		as.findId();
	}
	public void findDelId() {
		as.findDelId();
	}
	public void showInfo() {
		as.showResvInfo();
	}
	public void viewResvInfo() {
		as.cancelResv();
	}
	public void confirmCancel() {
		as.confirmCancel();
	}
}
