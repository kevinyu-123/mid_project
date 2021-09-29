package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import db.DBService;
import developers.soo.main.RegisterMem;
import developers.soo.service.Member;
import developers.soo.service.MemberImpl;
import dto.MemberDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemController implements Initializable {
	DBService dbservice;
	MemberDTO memdto;
	Member mb;

	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		mb.setRoot(root);
		mb.setCheckbox();
	}

	public void onSave() {
		mb.MemInput();
	}
	
	public void onClose() {
		mb.setClose();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		mb = new MemberImpl();
	}

}
