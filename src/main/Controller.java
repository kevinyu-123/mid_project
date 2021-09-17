package main;

import java.net.URL;
import java.util.ResourceBundle;

import developers.hj.mainClass.AdminMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable {
	Parent root;
	AdminMain am;
	public void setRoot(Parent root) {this.root=root;}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		am = new AdminMain();
		
	}
	public void fxAdminMenu(){
		am.adinLogin();
	}
	public void fxLogin(){}
	public void fxMemInsert(){}
	public void fxLookingPw(){}
}
