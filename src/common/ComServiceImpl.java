package common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ComServiceImpl implements ComService{
	public static void close(Parent root) {
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
	public static void Alart (String msg) {
		Alert alart = new Alert(AlertType.ERROR);
		alart.setTitle("error");
		//alart.setHeaderText("로그인 창");
		alart.setContentText(msg);
		alart.show();
	}
}

