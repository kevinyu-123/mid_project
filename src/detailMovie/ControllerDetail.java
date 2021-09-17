package detailMovie;

import java.net.URL;


import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;


public class ControllerDetail implements Initializable {
	Parent root;
	ImageView img = new ImageView();
	MediaService ms;

	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root,"/media/movie_video1.mp4");
	}

	public void gotoSeatPage() {
		System.out.println("좌석선택페이지");
		
	}
	public void gotoReviewPage() {
		System.out.println("선호도및리뷰페이지");
	}

	public void myPlay() { ms.myStart(); }
	public void myStop() { ms.myStop(); }
	public void myPause() { ms.myPause(); }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
	}

}
