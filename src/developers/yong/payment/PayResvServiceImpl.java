package developers.yong.payment;

import db.DBServiceImpl;
import developers.yong.resvView.ResvViewService;
import developers.yong.resvView.ResvViewServiceImpl;
import dto.ResvDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PayResvServiceImpl implements PayResvService{
	Parent viewroot;
	ResvDTO dto;
	public void setDTO(ResvDTO dto) {this.dto=dto;}
	// 결제창 화면
	public void payResvView(Parent root) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/yong/PaymentView.fxml"));
			viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//PayResvController controller = loader.getController();
			//controller.setRoot(viewroot);
			Scene scene = new Scene(viewroot);
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.setTitle("결제창");
			s.show();
			mvInfoView(viewroot);
			pay_Discnt(viewroot);
			payButton(viewroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 영화 내용 뷰
	public void mvInfoView(Parent root) {
		ImageView imgv = (ImageView) root.lookup("#fxMvImage");
		if(dto.getTitle().equals("")) {
			Image img = new Image("");
			imgv.setImage(img);
			imgv.prefHeight(100);
			imgv.prefWidth(100);
		}
		if(dto.getTitle().equals("")) {
			Image img = new Image("");
			imgv.setImage(img);
			imgv.prefHeight(100);
			imgv.prefWidth(100);
		}
		if(dto.getTitle().equals("")) {
			Image img = new Image("");
			imgv.setImage(img);
			imgv.prefHeight(100);
			imgv.prefWidth(100);
		}
		if(dto.getTitle().equals("")) {
			Image img = new Image("");
			imgv.setImage(img);
			imgv.prefHeight(100);
			imgv.prefWidth(100);
		}
	}
	// 결제 - 할인
	public void pay_Discnt(Parent root) {
		Label amount = (Label)root.lookup("#fxAmount");
		Label discount = (Label)root.lookup("#fxDiscount");
		Label totalPay = (Label)root.lookup("#fxTotalPay");
		amount.setText(dto.getAmount()+"원");
		int discnt = 0;
		int totalCnt = dto.getAmount()-discnt;
		totalPay.setText(totalCnt+"원");
		dto.setAmount(totalCnt);
		
	}
	// 결제수단
	public void pay_with(Parent root) {
		RadioButton cc = (RadioButton)root.lookup("#fxCC");
		RadioButton kakao = (RadioButton)root.lookup("#fxKakao");
		RadioButton bank = (RadioButton)root.lookup("#fxBank");
		RadioButton toss = (RadioButton)root.lookup("#fxToss");
		if(cc.isSelected()) {dto.setPayWith("신용카드");}
		if(kakao.isSelected()) {dto.setPayWith("카카오페이");}
		if(bank.isSelected()) {dto.setPayWith("무통장입금");}
		if(toss.isSelected()) {dto.setPayWith("Toss");}
	}
	// 사용자 티켓 내용 
	public void payButton(Parent root) {
		Button payBtn = (Button)viewroot.lookup("#fxPayButton");
		payBtn.setOnMouseClicked(e->{
			pay_with(viewroot);
			DBServiceImpl dbs = new DBServiceImpl();
			dbs.updateResv(dto);
			ResvViewService rvs = new ResvViewServiceImpl();
			rvs.resvView(root,dto.getResvNo());
		});
	}
}


