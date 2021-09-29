package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import db.DBService;
import developers.soo.service.Login;
import developers.soo.service.LoginImpl;
import dto.MemberDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class LoginController implements Initializable {
	DBService dbservice;
	MemberDTO memdto;
	Login login;

	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		login.setRoot(root);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DBCommon.setDBConnection();
		login = new LoginImpl();
	}

}
