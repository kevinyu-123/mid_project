package developers.soo.service;

import developers.eunbyul.mainMovie.MainMovie;
import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import developers.soo.main.MyPageMain;
import dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginImpl implements Login {
	MemberDTO memdto;
	DBService ds;
	MyPageMain mpm = new MyPageMain();
	Parent root;
	static String id;
	public static String getId() {return LoginImpl.id;}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public LoginImpl() {
		ds = new DBServiceImpl();
	}
	

	@Override
	public void login() {
//		memdto = new MemberDTO();
		System.out.println("로그인 버튼 클릭 시 떠야함");
		TextField id = (TextField)root.lookup("#fxId");
		PasswordField pwd = (PasswordField)root.lookup("#fxPwd");
		
		// 잘 되는지 확인
		System.out.println("id : " + id.getText());
		System.out.println("pwd : " + pwd.getText());
		
		MemberDTO memdto = ds.loginCheck(id.getText());
		if (memdto != null) {
			if (memdto.getId().equals(id.getText()) && memdto.getPassword().equals(pwd.getText())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("인증 성공");
			alert.show();
			
			mpm.myPage();
			MainMovie mm = new MainMovie();
			this.id = id.getText();
			mm.start(root);
			
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("아이디와 비밀번호를 확인해 주세요.");
				alert.show();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("해당하는 아이디나 비밀번호가 존재하지 않습니다.");
			alert.show();
		}
	}
}
