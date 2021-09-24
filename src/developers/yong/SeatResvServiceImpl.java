package developers.yong;

import java.text.DecimalFormat;
import java.util.ArrayList;

import common.ComService;
import common.ComServiceImpl;
import dto.ResvDTO;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SeatResvServiceImpl implements SeatResvService{
	Parent root;
	ResvDTO dto;
	int adtPrice = 15000, cdrPrice = 10000,
			adtAmount = 0,cdrAmount = 0,allAmount = 0,
			adtTicket = 0,cdrTicket = 0,allTicket= 0;
	String seatNum;
	ArrayList<String> allSeatNum = new ArrayList<String>();
	// 영화선택창에서 dto 받아와야함
	public void setRoot(Parent root) {this.root=root;}
	// 숫자 3자리마다 콤마 넣기
	DecimalFormat decFormat = new DecimalFormat("###,###");
	// 관리자가 티켓 금액 변경
	public void ticketPriceChange() {
		Label adtPrice = (Label)root.lookup("#fxAdtPriceChange");
		Label cdrPrice = (Label)root.lookup("#fxCdrPriceChange");
		adtPrice.setText(  ""+" X");
		cdrPrice.setText(  ""+" X");
	}
	// 성인 티켓 체크
	public void adtPrice() {
		Label adtPrice = (Label)root.lookup("#fxAdtPrice");
		String str = decFormat.format(adtAmount);
		adtPrice.setText(adtTicket+" = "+str+"원");
	}
	public void adt0() {this.adtTicket = 0; this.adtAmount = 0;adtPrice();amount();}
	public void adt1() {this.adtTicket = 1; this.adtAmount = adtPrice;adtPrice();amount();}
	public void adt2() {this.adtTicket = 2; this.adtAmount = adtPrice*2;adtPrice();amount();}
	public void adt3() {this.adtTicket = 3; this.adtAmount = adtPrice*3;adtPrice();amount();}
	
	// 청소년 티켓 체크
	public void cdrPrice() {
		Label cdrPrice = (Label)root.lookup("#fxCdrPrice");
		String str = decFormat.format(cdrAmount);
		cdrPrice.setText(cdrTicket+" = "+str+"원");
	}
	public void cdr0() {this.cdrTicket = 0; this.cdrAmount = 0;cdrPrice();amount();}
	public void cdr1() {this.cdrTicket = 1; this.cdrAmount = cdrPrice;cdrPrice();amount();}
	public void cdr2() {this.cdrTicket = 2; this.cdrAmount = cdrPrice*2;cdrPrice();amount();}
	public void cdr3() {this.cdrTicket = 3; this.cdrAmount = cdrPrice*3;cdrPrice();amount();}
	// 총 결제금액 변경
	public void amount() {
		allAmount = adtAmount + cdrAmount;
		allTicket = adtTicket + cdrTicket;
		Label amount = (Label)root.lookup("#fxAmount");
		String str = decFormat.format(allAmount);
		amount.setText(str);
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
			if(allSeatNum.size()<allTicket) {
				allSeatNum.add(seatNum);
				System.out.println(allSeatNum);
			}
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
	//좌석 선택후 티켓수를 줄였을 시 좌석 삭제
	public void seatlistDelete(ToggleButton btn, String alp, String num) {
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
	public void a1() {
		ToggleButton btnA1 = (ToggleButton)root.lookup("#aa1");String alp = "a";String num = "1"; 
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA1,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가"); seatlistDelete(btnA1,alp,num);}}
	public void a2() {
		ToggleButton btnA2 =(ToggleButton)root.lookup("#aa2");String alp = "a";String num = "2";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA2,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA2,alp,num);}}
	public void a3() {
		ToggleButton btnA3 = (ToggleButton)root.lookup("#aa3");String alp = "a";String num = "3";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA3,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA3,alp,num);}}
	public void a4() {
		ToggleButton btnA4 = (ToggleButton)root.lookup("#aa4");String alp = "a";String num = "4";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA4,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA4,alp,num);}}
	public void a5() {
		ToggleButton btnA5 = (ToggleButton)root.lookup("#aa5");String alp = "a";String num = "5";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA5,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA5,alp,num);}}
	public void a6() {
		ToggleButton btnA6 = (ToggleButton)root.lookup("#aa6");String alp = "a";String num = "6";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA6,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA6,alp,num);}}
	public void a7() {
		ToggleButton btnA7 = (ToggleButton)root.lookup("#aa7");String alp = "a";String num = "7";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnA7,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnA7,alp,num);}}
	
	public void b1() {
		ToggleButton btnB1 = (ToggleButton)root.lookup("#bb1");String alp = "b";String num = "1"; 
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB1,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB1,alp,num);}}
	public void b2() {
		ToggleButton btnB2 = (ToggleButton)root.lookup("#bb2");String alp = "b";String num = "2";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB2,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB2,alp,num);}}
	public void b3() {
		ToggleButton btnB3 = (ToggleButton)root.lookup("#bb3");String alp = "b";String num = "3";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB3,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB3,alp,num);}}
	public void b4() {
		ToggleButton btnB4 = (ToggleButton)root.lookup("#bb4");String alp = "b";String num = "4";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB4,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB4,alp,num);}}
	public void b5() {
		ToggleButton btnB5 = (ToggleButton)root.lookup("#bb5");String alp = "b";String num = "5";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB5,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB5,alp,num);}}
	public void b6() {
		ToggleButton btnB6 = (ToggleButton)root.lookup("#bb6");String alp = "b";String num = "6";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB6,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB6,alp,num);}}
	public void b7() {
		ToggleButton btnB7 = (ToggleButton)root.lookup("#bb7");String alp = "b";String num = "7";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnB7,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnB7,alp,num);}}
	
	public void c1() {
		ToggleButton btnC1 = (ToggleButton)root.lookup("#cc1");String alp = "c";String num = "1";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC1,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC1,alp,num);}}
	public void c2() {
		ToggleButton btnC2 = (ToggleButton)root.lookup("#cc2");String alp = "c";String num = "2";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC2,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC2,alp,num);}}
	public void c3() {
		ToggleButton btnC3 = (ToggleButton)root.lookup("#cc3");String alp = "c";String num = "3";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC3,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC3,alp,num);}}
	public void c4() {
		ToggleButton btnC4 = (ToggleButton)root.lookup("#cc4");String alp = "c";String num = "4";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC4,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC4,alp,num);}}
	public void c5() {
		ToggleButton btnC5 = (ToggleButton)root.lookup("#cc5");String alp = "c";String num = "5";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC5,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC5,alp,num);}}
	public void c6() {
		ToggleButton btnC6 = (ToggleButton)root.lookup("#cc6");String alp = "c";String num = "6";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC6,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC6,alp,num);}}
	public void c7() {
		ToggleButton btnC7 = (ToggleButton)root.lookup("#cc7");String alp = "c";String num = "7";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnC7,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnC7,alp,num);}}
	
	public void d1() {
		ToggleButton btnD1 = (ToggleButton)root.lookup("#dd1");String alp = "d";String num = "1";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD1,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD1,alp,num);}}
	public void d2() {
		ToggleButton btnD2 = (ToggleButton)root.lookup("#dd2");String alp = "d";String num = "2";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD2,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD2,alp,num);}}
	public void d3() {
		ToggleButton btnD3 = (ToggleButton)root.lookup("#dd3");String alp = "d";String num = "3";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD3,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD3,alp,num);}}
	public void d4() {
		ToggleButton btnD4 = (ToggleButton)root.lookup("#dd4");String alp = "d";String num = "4";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD4,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD4,alp,num);}}
	public void d5() {
		ToggleButton btnD5 = (ToggleButton)root.lookup("#dd5");String alp = "d";String num = "5";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD5,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD5,alp,num);}}
	public void d6() {
		ToggleButton btnD6 = (ToggleButton)root.lookup("#dd6");String alp = "d";String num = "6";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD6,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD6,alp,num);}}
	public void d7() {
		ToggleButton btnD7 = (ToggleButton)root.lookup("#dd7");String alp = "d";String num = "7";
		if(allSeatNum.size()<allTicket) {setBtnGrp(btnD7,alp,num);}
		else {ComServiceImpl.Alart(allTicket+"좌석 이상 선택 불가");seatlistDelete(btnD7,alp,num);}}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
