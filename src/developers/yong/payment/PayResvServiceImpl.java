package developers.yong.payment;

import dto.ResvDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PayResvServiceImpl implements PayResvService{
	Parent root;
	ResvDTO dto;
	public void setRoot(Parent root, ResvDTO dto) {this.root = root; this.dto = dto;}
	public void payResvView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/yong/PaymentView.fxml"));
			Parent viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PayResvController controller = loader.getController();
			controller.setRoot(viewroot);
			Scene scene = new Scene(viewroot);
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.setTitle("결제창");
			s.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


