package developers.yong;

import dto.ResvDTO;
import javafx.scene.Parent;

public interface SeatResvService {
	public void setRoot(Parent root);
	// 성인 티켓 체크
	public void adt0(); public void adt1(); public void adt2(); public void adt3();
	public void adtPrice();
	// 청소년 티켓 체크
	public void cdr0(); public void cdr1(); public void cdr2(); public void cdr3();
	public void cdrPrice();
	// 총 결제금액 변경
	public void amount();
	// 영화선택 메뉴로 돌아가기
	public void mvChoice();
	// 결제 선택 메뉴로 들어가기
	public ResvDTO payChoice();
	//좌석 선택

	//좌석 클릭 이미지 변경
	public void a1();public void a2();public void a3();public void a4();public void a5();public void a6();public void a7();
	public void b1();public void b2();public void b3();public void b4();public void b5();public void b6();public void b7();
	public void c1();public void c2();public void c3();public void c4();public void c5();public void c6();public void c7();
	public void d1();public void d2();public void d3();public void d4();public void d5();public void d6();public void d7();
	

}
