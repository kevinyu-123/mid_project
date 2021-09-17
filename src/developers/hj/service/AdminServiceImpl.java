package developers.hj.service;

import developers.hj.db.DBSerivceImpl;
import developers.hj.db.DBService;
import developers.hj.mainClass.SecondPage;
import dto.AdminDTO;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdminServiceImpl implements AdminService {
	Parent root;
	SecondPage sp = new SecondPage();
	DBService ds;
	public AdminServiceImpl(){
		ds = new DBSerivceImpl();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void login() {
		try {
		int next = check();
		if (next == 1) {
			sp.adminWorkspace();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("잘못된 정보입니다.");
			alert.show();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewMem() {

	}

	@Override
	public void addMovie() {

	}

	@Override
	public void deleteMovie() {

	}

	@Override
	public void resrvInfo() {

	}

	private String getId() {
		TextField id = (TextField) root.lookup("#adminId");
		return id.getText();
	}

	private String getPwd() {
		PasswordField pwd = (PasswordField) root.lookup("#adminPwd");
		return pwd.getText();
	}

	private String getMemNo() {
		PasswordField memNo = (PasswordField) root.lookup("#memNo");
		return memNo.getText();
	}

	private int check() {
		AdminDTO dto = ds.getInfo(getId());
		int i = 0;
		if (dto != null) {
			if (dto.getId().equals(getId()) && dto.getPwd().equals(getPwd()) && dto.getMemNo().equals(getMemNo())) {
				i = 1;
			}
		} else {
			i = 0;
		}
		return i;
	}
}
