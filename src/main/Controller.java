package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import developers.soo.MemInsert;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable {
	MemInsert mi;
	Parent root;
	public void setRoot(Parent root) {this.root=root; mi.setRoot(root);}
	public void fxAdminMenu(){}
	public void fxLogin(){}
	public void fxMemInsert(){
		mi.MemScreen();
	}
	public void fxLookingPw(){}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mi = new MemInsert();
	}
}
