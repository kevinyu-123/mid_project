package developers.soo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.DBCommon;
import developers.hj.mainClass.AdminMain;
import developers.soo.main.MyPageMain;
import developers.soo.main.PwdSearch;
import developers.soo.main.RegisterMem;
import developers.soo.service.Login;
import developers.soo.service.LoginImpl;
import developers.soo.service.Member;
import developers.soo.service.MemberImpl;
import developers.soo.service.PwdSearchImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable{
	Member mb;
	RegisterMem rm;		// 회원가입
	Login login;	// 로그인
	PwdSearch ps;	// 패스워드 찾기
	ImageView fxImageView;
	AdminMain am;	// 관리자 모드
	MyPageMain mp;		// 마이페이지
	
	Parent root;
	public void setRoot(Parent root) {
		this.root=root;
		login.setRoot(root);
//		fxImageView = (ImageView)root.lookup("#fxImageView");
//		fxImageView.setImage(new Image("/developers/soo/style/1111.PNG"));
	}
	public void fxAdminMenu(){
		am.adinLogin();
	}
	public void fxLogin(){
		login.login();
	}
	public void fxMemInsert(){
		rm.register();
	}
	public void fxLookingPw(){
		ps.pwdPopUp();
	}
	
	public void onMyPage() {
		mp.myPage();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DBCommon.setDBConnection();
		mb = new MemberImpl();
		rm = new RegisterMem();
		login = new LoginImpl();
		ps = new PwdSearch();
		fxImageView = new ImageView();
		am = new AdminMain();
		mp = new MyPageMain();
	}
}
