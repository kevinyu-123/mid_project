package detail;


import java.io.IOException;

import db.DBService;
import detail.Controller.DetailController01;
import detail.Controller.DetailController10;
import dto.MovieDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class detail10{
	DBService db = new DBService();
	//MovieDTO dto = db.selectSQL("모가디슈");
	
	public void start()  {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/detail/fxmlPages/detail10.fxml"));
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		DetailController10 ctl = loader.getController();
		ctl.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		///////////////////////////////////////////
	
		DetailController10 dc = loader.getController();
		dc.setRoot(root);
		
		MovieDTO dto = db.selectSQL("test");
		Label movieTitle = (Label) root.lookup("#movieTitle");
		Label movieDate = (Label) root.lookup("#movieDate");
		Label movieInfomation = (Label) root.lookup("#movieInfomation");
		Label movieNation = (Label) root.lookup("#movieNation");
		Label movieDirector = (Label) root.lookup("#movieDirector");
		Label movieActor = (Label) root.lookup("#movieActor");
		Label movieFilmrate = (Label) root.lookup("#movieFilmrate");
		Label movieRunningtime = (Label)root.lookup("#movieRunningtime");
		movieTitle.setText(dto.getTitle());
		movieDate.setText(dto.getMovieDate());
		movieInfomation.setText(dto.getInfomation());
		movieNation.setText(dto.getNation());
		movieDirector.setText(dto.getDirector());
		movieActor.setText(dto.getActor());
		movieFilmrate.setText(dto.getFilmRate());
		movieRunningtime.setText(dto.getRunningTime()+"분");
		
	}
	public static void main(String[] args) {

	}

}