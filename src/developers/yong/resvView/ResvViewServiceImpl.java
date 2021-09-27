package developers.yong.resvView;
import db.DBServiceImpl;
import dto.ResvDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ResvViewServiceImpl implements ResvViewService{
	public void resvView(Parent root, String memId) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/yong/ReservView.fxml"));
		Parent viewRoot = null;
		try {
			viewRoot = loader.load();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//ResvViewController ctl = loader.getController();
		//ctl.setRoot(root);
		Stage s = (Stage) root.getScene().getWindow();
		s.setScene(new Scene(viewRoot));
		s.show();
		
		TextField title = (TextField)viewRoot.lookup("#fxMvTitle");
		TextField id = (TextField)viewRoot.lookup("#fxId");
		TextField resvNum = (TextField)viewRoot.lookup("#fxResvNum");
		TextField resvDate = (TextField)viewRoot.lookup("#fxResvDate");
		TextField theater = (TextField)viewRoot.lookup("#fxTheater");
		TextField ticket = (TextField)viewRoot.lookup("#fxTicket");
		TextField seatNum = (TextField)viewRoot.lookup("#fxSeatNum");
		TextField paymentDay = (TextField)viewRoot.lookup("#fxPayMentDay");
		TextField payWith = (TextField)viewRoot.lookup("#fxPayWith");
		TextField amount = (TextField)viewRoot.lookup("#fxAmount");
		
		DBServiceImpl dbs = new DBServiceImpl();
		ResvDTO dto = new ResvDTO();
		dto = dbs.toIdgetResv("id4321");
		
		title.setText(dto.getTitle());
		id.setText(dto.getId());
		resvNum.setText(dto.getResvNo());
		resvDate.setText(dto.getResvDate());
		theater.setText(dto.getTheater());
		String allTicket = ("성인 "+dto.getAdtTicket()+" 청소년 "+dto.getCdrTicket());
		ticket.setText(allTicket);
		seatNum.setText(dto.getSeatNum());
		paymentDay.setText(dto.getPaymentDay());
		payWith.setText(dto.getPayWith());
		amount.setText(dto.getAmount()+" 원");
		
		Button resvCancel = (Button)viewRoot.lookup("#ResvCancel");
		resvCancel.setOnMouseClicked(e->{
			s.close();
		});
	}
}
