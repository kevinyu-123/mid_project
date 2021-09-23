package developers.yong;

import java.util.ArrayList;

import dto.ResvDTO;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SeatResvServiceImpl implements SeatResvService{
	Parent root;
	ResvDTO dto;
	int adtAmount = 0,cdrAmount = 0,allAmount = 0, ticket = 0;
	String seatNum;
	ArrayList<String> allSeatNum = new ArrayList<String>();
	//영화선택창에서 dto 받아와야함
	public void setRoot(Parent root) {this.root=root;}
	
	// 성인 티켓 체크
	public void adtPrice() {
		Label adtPrice = (Label)root.lookup("#fxAdtPrice");
		adtPrice.setText(ticket+" = "+adtAmount+",000 원");
	}
	public void adt0() {this.ticket = 0; this.adtAmount = 0;adtPrice();amount();}
	public void adt1() {this.ticket = 1; this.adtAmount = 15;adtPrice();amount();}
	public void adt2() {this.ticket = 2; this.adtAmount = 30;adtPrice();amount();}
	public void adt3() {this.ticket = 3; this.adtAmount = 45;adtPrice();amount();}
	
	// 청소년 티켓 체크
	public void cdrPrice() {
		Label cdrPrice = (Label)root.lookup("#fxCdrPrice");
		cdrPrice.setText(ticket+" = "+cdrAmount+",000 원");
	}
	public void cdr0() {this.ticket = 0; this.cdrAmount = 0;cdrPrice();amount();}
	public void cdr1() {this.ticket = 1; this.cdrAmount = 10;cdrPrice();amount();}
	public void cdr2() {this.ticket = 2; this.cdrAmount = 20;cdrPrice();amount();}
	public void cdr3() {this.ticket = 3; this.cdrAmount = 30;cdrPrice();amount();}
	// 총 결제금액 변경
	public void amount() {
		allAmount = adtAmount + cdrAmount;
		Label amount = (Label)root.lookup("#fxAmount");
		amount.setText(allAmount+",000");
	}
	// 영화선택 메뉴로 돌아가기
	public void mvChoice() {}
	
	// 결제 선택 메뉴로 들어가기
	public ResvDTO payChoice() {
		//dto 객체 받아서 거기에다가 저장
		dto = new ResvDTO();
		dto.setAmount(allAmount);
		dto.setSeatNum(allSeatNum);
		//성인 0표 청소년 0 표 db, dto 작성 
		return dto;
	}
	//예약좌석 DTO 받아서 이미지 변경하기
	//public void resvdSeat() {}
	
	//좌석 선택 , 좌석 클릭 이미지 변경
	public void setBtnGrp(ToggleButton btn, String alp, String num) {
		if(btn.isSelected()) {
			Image img = new Image("developers/yong/seatImage/blueNum/free-icon-"+num+".png");
			ImageView imgv = new ImageView(img);
			imgv.setFitHeight(30.0);
			imgv.setFitWidth(30.0);
			btn.setGraphic(imgv);
			seatNum = alp+num;
			allSeatNum.add(seatNum);
		}else {
			Image img = new Image("developers/yong/seatImage/whiteNum/free-icon-"+num+".png");
			ImageView imgv = new ImageView(img);
			imgv.setFitHeight(30.0);
			imgv.setFitWidth(30.0);
			btn.setGraphic(imgv);
			seatNum = alp+num;
			if(allSeatNum.contains(seatNum)) {
				allSeatNum.remove(seatNum);
			}
		}
	}
	public void a1() {
		ToggleButton btnA1 = (ToggleButton)root.lookup("#aa1");String alp = "a";String num = "1"; setBtnGrp(btnA1,alp,num);}
	public void a2() {
		ToggleButton btnA2 = (ToggleButton)root.lookup("#aa2");String alp = "a";String num = "2";setBtnGrp(btnA2,alp,num);}
	public void a3() {
		ToggleButton btnA3 = (ToggleButton)root.lookup("#aa3");String alp = "a";String num = "3";setBtnGrp(btnA3,alp,num);}
	public void a4() {
		ToggleButton btnA4 = (ToggleButton)root.lookup("#aa4");String alp = "a";String num = "4";setBtnGrp(btnA4,alp,num);}
	public void a5() {
		ToggleButton btnA5 = (ToggleButton)root.lookup("#aa5");String alp = "a";String num = "5";setBtnGrp(btnA5,alp,num);}
	public void a6() {
		ToggleButton btnA6 = (ToggleButton)root.lookup("#aa6");String alp = "a";String num = "6";setBtnGrp(btnA6,alp,num);}
	public void a7() {
		ToggleButton btnA7 = (ToggleButton)root.lookup("#aa7");String alp = "a";String num = "7";setBtnGrp(btnA7,alp,num);}
	
	public void b1() {
		ToggleButton btnB1 = (ToggleButton)root.lookup("#bb1");String alp = "b";String num = "1"; setBtnGrp(btnB1,alp,num);}
	public void b2() {
		ToggleButton btnB2 = (ToggleButton)root.lookup("#bb2");String alp = "b";String num = "2";setBtnGrp(btnB2,alp,num);}
	public void b3() {
		ToggleButton btnB3 = (ToggleButton)root.lookup("#bb3");String alp = "b";String num = "3";setBtnGrp(btnB3,alp,num);}
	public void b4() {
		ToggleButton btnB4 = (ToggleButton)root.lookup("#bb4");String alp = "b";String num = "4";setBtnGrp(btnB4,alp,num);}
	public void b5() {
		ToggleButton btnB5 = (ToggleButton)root.lookup("#bb5");String alp = "b";String num = "5";setBtnGrp(btnB5,alp,num);}
	public void b6() {
		ToggleButton btnB6 = (ToggleButton)root.lookup("#bb6");String alp = "b";String num = "6";setBtnGrp(btnB6,alp,num);}
	public void b7() {
		ToggleButton btnB7 = (ToggleButton)root.lookup("#bb7");String alp = "b";String num = "7";setBtnGrp(btnB7,alp,num);}
	
	public void c1() {
		ToggleButton btnC1 = (ToggleButton)root.lookup("#cc1");String alp = "c";String num = "1";setBtnGrp(btnC1,alp,num);}
	public void c2() {
		ToggleButton btnC2 = (ToggleButton)root.lookup("#cc2");String alp = "c";String num = "2";setBtnGrp(btnC2,alp,num);}
	public void c3() {
		ToggleButton btnC3 = (ToggleButton)root.lookup("#cc3");String alp = "c";String num = "3";setBtnGrp(btnC3,alp,num);}
	public void c4() {
		ToggleButton btnC4 = (ToggleButton)root.lookup("#cc4");String alp = "c";String num = "4";setBtnGrp(btnC4,alp,num);}
	public void c5() {
		ToggleButton btnC5 = (ToggleButton)root.lookup("#cc5");String alp = "c";String num = "5";setBtnGrp(btnC5,alp,num);}
	public void c6() {
		ToggleButton btnC6 = (ToggleButton)root.lookup("#cc6");String alp = "c";String num = "6";setBtnGrp(btnC6,alp,num);}
	public void c7() {
		ToggleButton btnC7 = (ToggleButton)root.lookup("#cc7");String alp = "c";String num = "7";setBtnGrp(btnC7,alp,num);}
	
	public void d1() {
		ToggleButton btnD1 = (ToggleButton)root.lookup("#dd1");String alp = "d";String num = "1";setBtnGrp(btnD1,alp,num);}
	public void d2() {
		ToggleButton btnD2 = (ToggleButton)root.lookup("#dd2");String alp = "d";String num = "2";setBtnGrp(btnD2,alp,num);}
	public void d3() {
		ToggleButton btnD3 = (ToggleButton)root.lookup("#dd3");String alp = "d";String num = "3";setBtnGrp(btnD3,alp,num);}
	public void d4() {
		ToggleButton btnD4 = (ToggleButton)root.lookup("#dd4");String alp = "d";String num = "4";setBtnGrp(btnD4,alp,num);}
	public void d5() {
		ToggleButton btnD5 = (ToggleButton)root.lookup("#dd5");String alp = "d";String num = "5";setBtnGrp(btnD5,alp,num);}
	public void d6() {
		ToggleButton btnD6 = (ToggleButton)root.lookup("#dd6");String alp = "d";String num = "6";setBtnGrp(btnD6,alp,num);}
	public void d7() {
		ToggleButton btnD7 = (ToggleButton)root.lookup("#dd7");String alp = "d";String num = "7";setBtnGrp(btnD7,alp,num);}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
