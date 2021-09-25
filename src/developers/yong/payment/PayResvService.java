package developers.yong.payment;

import dto.ResvDTO;
import javafx.scene.Parent;

public interface PayResvService {
	public void setRoot(Parent root,ResvDTO dto);
	public void payResvView();
	
}
