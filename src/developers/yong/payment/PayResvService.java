package developers.yong.payment;

import dto.ResvDTO;
import javafx.scene.Parent;

public interface PayResvService {
	public void setDTO(ResvDTO dto);
	public void payResvView(Parent root);
	public void mvInfoView(Parent root);
	public void pay_Discnt(Parent root);
	public void pay_with(Parent root);
	//public void payButton(Parent root);
}
