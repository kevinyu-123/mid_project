package developers.soo;

import java.io.IOException;
import db.DBService;
import dto.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemInsert {
	DBService dbservice;
	MemberDTO dbdto;
	
	Parent root;
	public void setRoot(Parent root) {this.root = root;}

	public void MemScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberShip.fxml"));
		Parent viewRoot = null;
		try {
			viewRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemController ctl = loader.getController();
		ctl.setRoot(viewRoot);
		Scene scene = new Scene(viewRoot);
		Stage stage = new Stage();	
		stage.setScene(scene);
		stage.show();
	}
	
	public void MemInput() {
		TextField id = (TextField)root.lookup("fxId");
		PasswordField pwd = (PasswordField)root.lookup("fxPwd");
		TextField email = (TextField)root.lookup("fxEmail");
		TextField name = (TextField)root.lookup("fxName");
		ComboBox<String> pwdQuestion = (ComboBox<String>)root.lookup("#fxQuestion");
		TextField pwdAnswer = (TextField)root.lookup("fxAnswer");
		
		if (id == null) {
			System.out.println("아이디를 입력해 주세요.");
		} else {  
			dbdto.setId(id.getText());
			System.out.println("정상적으로 등록되었습니다.");
		}
		System.out.println(id);
	}
	public void onSave() {
		System.out.println("왜안됑?");
	}
	
	
	
	
}
