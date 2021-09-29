package developers.soo.service;

import java.io.IOException;

import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import dto.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MemberImpl implements Member{
	DBService ds;
	MemberDTO memdto;
	Parent root;
	public MemberImpl() {
		ds = new DBServiceImpl();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void MemInput() {
		memdto = new MemberDTO();
		
		TextField id = (TextField)root.lookup("#fxId");
		PasswordField pwd = (PasswordField)root.lookup("#fxPwd");
		TextField email = (TextField)root.lookup("#fxEmail");
		TextField name = (TextField)root.lookup("#fxName");
		ComboBox<String> pwdQuestion = (ComboBox<String>)root.lookup("#fxQuestion");
		TextField pwdAnswer = (TextField)root.lookup("#fxAnswer");
		
		if (id != null) {
			memdto.setId(id.getText());
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("오류입니다.");
			alert.show();
		}
		if (pwd != null) {
			memdto.setPassword(pwd.getText());
		} else {
			System.out.println("비밀번호를 입력해주세요.");
		}
		if (email != null) {
			memdto.setEmail(email.getText());
		} else {
			System.out.println("이메일을 입력해주세요.");
		}
		if (name != null) {
			memdto.setName(name.getText());
		} else {
			System.out.println("이름을 입력해주세요.");
		}
		if (pwdQuestion != null) {
			memdto.setPwdQuestion(pwdQuestion.getValue());
		} else {
			System.out.println("질문을 입력해주세요.");
		}
		if (pwdAnswer != null) {
			memdto.setPwdAnswer(pwdAnswer.getText());
		} else {
			System.out.println("대답을 입력해주세요.");
		}
		
		// 회원가입인지 아닌지 확인
		int result = ds.DBSave(memdto);
		if (result == 1) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("회원가입 성공");
			alert.show();
		}  else { 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("회원가입 실패");
			alert.show();
		}
	}
	@Override
	public void setCheckbox() {
		ComboBox<String> pwdQuestion = (ComboBox<String>)root.lookup("#fxQuestion");
		if (pwdQuestion != null) {
			pwdQuestion.getItems().addAll("당신의 초등학교는 ?", "당신의 보물 1호는? ", "당신의 첫사랑 이름은 ? ", "당신의 고향은 ?");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("오류입니다.");
			alert.show();
		}
	}
	@Override
	public void setClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
}
