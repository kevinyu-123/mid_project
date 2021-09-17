package developers.hj.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import developers.hj.service.AdminService;
import developers.hj.service.AdminServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class FController implements Initializable {
	Parent root;
	AdminService as;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		as = new AdminServiceImpl();
	}
	public void adminLogin() {
		as.login();
	}
	
}
