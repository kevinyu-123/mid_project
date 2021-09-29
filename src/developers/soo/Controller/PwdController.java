package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import developers.soo.service.Member;
import developers.soo.service.MemberImpl;
import developers.soo.service.PwdSearch;
import developers.soo.service.PwdSearchImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class PwdController implements Initializable {
	PwdSearch ps;
	Member mb;
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		ps.setRoot(root);
		ps.setCombo();
	}
	
	public void onClick() {
		ps.setPwd();
	}
	
	public void onClose() {
		ps.setClose();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		ps = new PwdSearchImpl();
		
	}

}
