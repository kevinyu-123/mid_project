package detail.Controller;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

import mainMovie.MediaServiceImpl;

public class DetailController04 implements Initializable {
	Parent root;
	
	MediaServiceImpl ms = new MediaServiceImpl();

	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root,"/media/video4.mp4");
	}

	public void gotoSeatPage() {
		System.out.println("좌석선택페이지");
	}
	public void gotoReviewPage() {
		System.out.println("선호도및리뷰페이지");
	}

	public void myPlay() { ms.myPlay(); }
	public void myStop() { ms.myStop(); }
	public void myPause() { ms.myPause(); }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
	
		
	}
	
	
	}
