package developers.soo.service;

import java.io.IOException;

import developers.soo.db.DBService;
import developers.soo.db.DBServiceImpl;
import dto.ResvDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ReserveImpl {
	DBService ds;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public ReserveImpl() {
		ds = new DBServiceImpl();
	}
	
	public void showInfo() {
		String str = resvCheck();
		ResvDTO dto = ds.resvCheck(str);
		
		
		if (dto != null && dto.getResvNo().equals(str)) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/soo/fxml/ReserveInfo.fxml"));
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
		
		TextField title = (TextField)viewRoot.lookup("#title");
		TextField reserveNo = (TextField)viewRoot.lookup("#number");
		TextField reserveDate = (TextField)viewRoot.lookup("#reserveDate");
		TextField theater = (TextField)viewRoot.lookup("#theater");
		TextField seat = (TextField)viewRoot.lookup("#seat");
		TextField amount = (TextField)viewRoot.lookup("#amount");
		TextField pMethod = (TextField)viewRoot.lookup("#pmethod");
		TextField pDate = (TextField)viewRoot.lookup("#pdate");
		TextField adult = (TextField)viewRoot.lookup("#adult");
		TextField cdr = (TextField)viewRoot.lookup("#cdr");
		Button delete = (Button)viewRoot.lookup("#delete");
		Button close = (Button)viewRoot.lookup("#close");
		
		
		title.setText(dto.getTitle());
		reserveNo.setText(dto.getResvNo());
		reserveDate.setText(dto.getResvDate());
		theater.setText(dto.getTheater());
		seat.setText(dto.getSeatNum());
		amount.setText(Integer.toString(dto.getAmount()));
		pMethod.setText(dto.getPayWith());
		pDate.setText(dto.getPaymentDay());
		adult.setText(dto.getAdtTicket());
		cdr.setText(dto.getCdrTicket());
		
		
		close.setOnMouseClicked(e-> {
			s.close();
		});
		
		delete.setOnMouseClicked(e-> {
			try {
				int result = ds.resvDelete(str);
				if(result == 1) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("예매취소를 완료하였습니다.");
					alert.show();
					s.close();
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("예매취소를 실패하였습니다.");
					alert.show();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("해당하는 예매정보가 없습니다.");
			alert.show();
			System.out.println("해당하는 예매정보가 없습니다.");
		}
		
		
	}
	
	private String resvCheck() {
		TextField reserveNo = (TextField)root.lookup("#reserveNo");
		return reserveNo.getText();
	}
}
