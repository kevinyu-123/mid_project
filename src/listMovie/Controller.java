package listMovie;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import detailMovie.MediaServiceImpl;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller implements Initializable {
	Parent root;
	ImageView img = new ImageView();
MediaServiceImpl ms;
	
	
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	public void gotoDetail() {
		System.out.println("디테일페이지로 갑니다");
		ms = new MediaServiceImpl();
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	       
	}

}
