package developers.yong;

import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SeatResvServiceImpl implements SeatResvService{
	Parent root;
	public void setRoot(Parent root) {this.root=root;}
	public void fxCdr0(){
	}
	
	public void setBtnGrp(ToggleButton btn, String num) {
		if(btn.isSelected()) {
			Image img = new Image("developers/yong/seatImage/blueNum/free-icon-"+num+".png");
			ImageView imgv = new ImageView(img);
			imgv.setFitHeight(30.0);
			imgv.setFitWidth(30.0);
			btn.setGraphic(imgv);
		}else {
			Image img = new Image("developers/yong/seatImage/whiteNum/free-icon-"+num+".png");
			ImageView imgv = new ImageView(img);
			imgv.setFitHeight(30.0);
			imgv.setFitWidth(30.0);
			btn.setGraphic(imgv);
		}
	}
	public void a1() {
		ToggleButton btnA1 = (ToggleButton)root.lookup("#aa1"); String a = "1"; setBtnGrp(btnA1,a);}
	public void a2() {
		ToggleButton btnA2 = (ToggleButton)root.lookup("#aa2");String a = "2";setBtnGrp(btnA2,a);}
	public void a3() {
		ToggleButton btnA3 = (ToggleButton)root.lookup("#aa3");String a = "3";setBtnGrp(btnA3,a);}
	public void a4() {
		ToggleButton btnA4 = (ToggleButton)root.lookup("#aa4");String a = "4";setBtnGrp(btnA4,a);}
	public void a5() {
		ToggleButton btnA5 = (ToggleButton)root.lookup("#aa5");String a = "5";setBtnGrp(btnA5,a);}
	public void a6() {
		ToggleButton btnA6 = (ToggleButton)root.lookup("#aa6");String a = "6";setBtnGrp(btnA6,a);}
	public void a7() {
		ToggleButton btnA7 = (ToggleButton)root.lookup("#aa7");String a = "7";setBtnGrp(btnA7,a);}
	
	public void b1() {
		ToggleButton btnB1 = (ToggleButton)root.lookup("#bb1"); String a = "1"; setBtnGrp(btnB1,a);}
	public void b2() {
		ToggleButton btnB2 = (ToggleButton)root.lookup("#bb2");String a = "2";setBtnGrp(btnB2,a);}
	public void b3() {
		ToggleButton btnB3 = (ToggleButton)root.lookup("#bb3");String a = "3";setBtnGrp(btnB3,a);}
	public void b4() {
		ToggleButton btnB4 = (ToggleButton)root.lookup("#bb4");String a = "4";setBtnGrp(btnB4,a);}
	public void b5() {
		ToggleButton btnB5 = (ToggleButton)root.lookup("#bb5");String a = "5";setBtnGrp(btnB5,a);}
	public void b6() {
		ToggleButton btnB6 = (ToggleButton)root.lookup("#bb6");String a = "6";setBtnGrp(btnB6,a);}
	public void b7() {
		ToggleButton btnB7 = (ToggleButton)root.lookup("#bb7");String a = "7";setBtnGrp(btnB7,a);}
	
	public void c1() {
		ToggleButton btnC1 = (ToggleButton)root.lookup("#cc1"); String a = "1"; setBtnGrp(btnC1,a);}
	public void c2() {
		ToggleButton btnC2 = (ToggleButton)root.lookup("#cc2");String a = "2";setBtnGrp(btnC2,a);}
	public void c3() {
		ToggleButton btnC3 = (ToggleButton)root.lookup("#cc3");String a = "3";setBtnGrp(btnC3,a);}
	public void c4() {
		ToggleButton btnC4 = (ToggleButton)root.lookup("#cc4");String a = "4";setBtnGrp(btnC4,a);}
	public void c5() {
		ToggleButton btnC5 = (ToggleButton)root.lookup("#cc5");String a = "5";setBtnGrp(btnC5,a);}
	public void c6() {
		ToggleButton btnC6 = (ToggleButton)root.lookup("#cc6");String a = "6";setBtnGrp(btnC6,a);}
	public void c7() {
		ToggleButton btnC7 = (ToggleButton)root.lookup("#cc7");String a = "7";setBtnGrp(btnC7,a);}
	
	public void d1() {
		ToggleButton btnD1 = (ToggleButton)root.lookup("#dd1"); String a = "1"; setBtnGrp(btnD1,a);}
	public void d2() {
		ToggleButton btnD2 = (ToggleButton)root.lookup("#dd2");String a = "2";setBtnGrp(btnD2,a);}
	public void d3() {
		ToggleButton btnD3 = (ToggleButton)root.lookup("#dd3");String a = "3";setBtnGrp(btnD3,a);}
	public void d4() {
		ToggleButton btnD4 = (ToggleButton)root.lookup("#dd4");String a = "4";setBtnGrp(btnD4,a);}
	public void d5() {
		ToggleButton btnD5 = (ToggleButton)root.lookup("#dd5");String a = "5";setBtnGrp(btnD5,a);}
	public void d6() {
		ToggleButton btnD6 = (ToggleButton)root.lookup("#dd6");String a = "6";setBtnGrp(btnD6,a);}
	public void d7() {
		ToggleButton btnD7 = (ToggleButton)root.lookup("#dd7");String a = "7";setBtnGrp(btnD7,a);}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
