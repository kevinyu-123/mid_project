package developers.hj.Controller;

import java.net.URL;

import java.util.ResourceBundle;

import common.DBCommon;
import developers.hj.service.AdminService;
import developers.hj.service.AdminServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class SController implements Initializable {
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

	public void viewMem() {
		as.viewMem();
	}
	
	public void addMovie() {
		as.addMovie();
	}
	
	public void deleteMovie() {
		as.deleteMovie();
	}

	public void resrvInfo() {
		as.resrvInfo();
	}
}
