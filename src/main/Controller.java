package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import developers.soo.MemInsert;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import developers.hj.mainClass.AdminMain;

public class Controller implements Initializable {
	Parent root;
	AdminMain am;
	MemInsert mi;
	
	public void setRoot(Parent root) {this.root=root; mi.setRoot(root);}
	public void fxAdminMenu(){am.adinLogin();}
	public void fxLogin(){}
	public void fxMemInsert(){
		mi.MemScreen();
	}
	public void fxLookingPw(){}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mi = new MemInsert();
		am = new AdminMain();
	}
}
