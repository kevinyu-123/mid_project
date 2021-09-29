package developers.soo.service;

import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class PwdSearchImpl implements PwdSearch {
	DBService ds;
	MemberDTO memdto;
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public PwdSearchImpl() {
		ds = new DBServiceImpl();
	}
//	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void setPwd() {
		memdto = new MemberDTO();
//		System.out.println("비밀번호 찾기 버튼 클릭 시 확인");
		TextField id = (TextField)root.lookup("#fxPwdId");
		ComboBox<String> pwdQuestion = (ComboBox<String>)root.lookup("#fxQuestion");
		TextField pwdAnswer = (TextField)root.lookup("#fxPwdAnswer");
		// 출력되는지 확인
		System.out.println("id : " + id.getText());
		System.out.println("pwdQuestion :" + pwdQuestion.getValue().toString());
		System.out.println("pwdAnswer :" + pwdAnswer.getText());
		
		MemberDTO memdto = ds.idCheck(id.getText());
		
		if (memdto != null) {
			if (memdto.getId().equals(id.getText()) && memdto.getPwdQuestion().equals(pwdQuestion.getValue()) && memdto.getPwdAnswer().equals(pwdAnswer.getText())) {
			System.out.println("db에 있는 아이디와 질문 대답");
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("당신의 비밀번호는 : " + memdto.getPassword() + " 입니다.");
			alert.show();
			
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("아이디와 답변을 확인해 주세요.");
				alert.show();
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("해당 아이디가 존재하지 않습니다.");
			alert.show();
		}
		
	}
	
	public void setCombo() {
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
