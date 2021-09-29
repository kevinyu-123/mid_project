package developers.soo.service;

import java.io.IOException;

import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import dto.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ModifyImpl {
	DBService ds;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public ModifyImpl() {
		ds = new DBServiceImpl();
	}
	
	public void modify() {
//		System.out.println("수정버튼클릭");
		String p = pwdCheck();
		MemberDTO memdto = ds.pwdCheck(p);
		String name = memdto.getId();
		if (memdto.getPassword().equals(p)) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/soo/fxml/MemModify.fxml"));
		Parent viewRoot = null;
		try {
			viewRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(viewRoot);
		Stage s = (Stage)root.getScene().getWindow(); 
		s.setScene(scene);
		
		TextField pwd = (TextField)viewRoot.lookup("#fxPwd");
		TextField email = (TextField)viewRoot.lookup("#fxEmail");
		ComboBox<String> question = (ComboBox<String>)viewRoot.lookup("#fxQuestion");
		TextField answer = (TextField)viewRoot.lookup("#fxAnswer");
		Button save = (Button)viewRoot.lookup("#fxSave");
		
		if (question != null) {
			question.getItems().addAll("당신의 초등학교는 ?", "당신의 보물 1호는? ", "당신의 첫사랑 이름은 ? ", "당신의 고향은 ?");
		}
		s.show();
		
		pwd.setText(memdto.getPassword());
		email.setText(memdto.getEmail());
		question.setPromptText(memdto.getPwdQuestion());
		answer.setText(memdto.getPwdAnswer());
		
		pwd.setOnMouseExited(e ->{
			memdto.setPassword(pwd.getText());
			System.out.println(memdto.getPassword());
		});
		email.setOnMouseExited(e ->{
			memdto.setEmail(email.getText());
			System.out.println(memdto.getEmail());
		});
		question.setOnMouseExited(e ->{
			memdto.setPwdQuestion(question.getValue());
			System.out.println(memdto.getPwdQuestion());
		});
		answer.setOnMouseExited(e ->{
			memdto.setPwdAnswer(answer.getText());
			System.out.println(memdto.getPwdAnswer());
		});
		save.setOnMouseClicked(e ->{
			int result = ds.memSave(memdto, name);
			if (result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		});
		
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("오류입니다.");
			alert.show();
		}
	}
	
	private String pwdCheck() {
		PasswordField pwd = (PasswordField)root.lookup("#pwd");
		return pwd.getText();
	}
}
