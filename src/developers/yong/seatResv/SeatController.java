package developers.yong.seatResv;

import java.net.URL;
import java.util.ResourceBundle;
import developers.yong.payment.PayResvService;
import developers.yong.payment.PayResvServiceImpl;
import dto.ResvDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class SeatController implements Initializable{
	Parent root;
	SeatResvService srs ;
	PayResvService prs;
	ResvDTO dto;
	public void setRoot(Parent root) {this.root=root; srs.setRoot(root);}
	
	//좌석 버튼 선택
	public void a1() {srs.a1();}public void a2() {srs.a2();}public void a3() {srs.a3();}public void a4() {srs.a4();}
	public void a5() {srs.a5();}public void a6() {srs.a6();}public void a7() {srs.a7();}
	public void b1() {srs.b1();}public void b2() {srs.b2();}public void b3() {srs.b3();}public void b4() {srs.b4();}
	public void b5() {srs.b5();}public void b6() {srs.b6();}public void b7() {srs.b7();}
	public void c1() {srs.c1();}public void c2() {srs.c2();}public void c3() {srs.c3();}public void c4() {srs.c4();}
	public void c5() {srs.c5();}public void c6() {srs.c6();}public void c7() {srs.c7();}
	public void d1() {srs.d1();}public void d2() {srs.d2();}public void d3() {srs.d3();}
	public void d4() {srs.d4();}public void d5() {srs.d5();}public void d6() {srs.d6();}public void d7() {srs.d7();}
	//성인 인원수 선택
	public void fxAdt0() {srs.adt0();}
	public void fxAdt1() {srs.adt1();}
	public void fxAdt2() {srs.adt2();}
	public void fxAdt3() {srs.adt3();}
	//청소년 인원수 선택
	public void fxCdr0() {srs.cdr0();}
	public void fxCdr1() {srs.cdr1();}
	public void fxCdr2() {srs.cdr2();}
	public void fxCdr3() {srs.cdr3();}
	
	//DTO와 같이 결제선택창으로 넘어가기
	public void fxPayWith(){
		dto = srs.payChoice();
		if(dto.getSeatNum()!="[]") {
			prs.setDTO(dto);
			prs.payResvView(root);
		}else {
			System.out.println("저장 없음");
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		srs = new SeatResvServiceImpl();
		prs = new PayResvServiceImpl();
		dto = new ResvDTO();
	}
}


