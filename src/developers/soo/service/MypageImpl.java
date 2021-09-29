package developers.soo.service;

import java.io.IOException;

import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import developers.soo.main.CheckReserveNo;
import developers.soo.main.ModifyMy;
import dto.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MypageImpl implements Mypage {
	DBService ds;
	MemberDTO memdto;
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public MypageImpl() {
		ds = new DBServiceImpl();
	}

	@Override
	public void setModify() {
		System.out.println("정보수정버튼");
		ModifyMy mm = new ModifyMy();
		mm.ModifyMyPage();
	}

	@Override
	public void setView() {
//		System.out.println("예매내역확인버튼");
		CheckReserveNo crn = new CheckReserveNo();
		crn.check();
	}
	
	@Override
	public void setClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}		

}
