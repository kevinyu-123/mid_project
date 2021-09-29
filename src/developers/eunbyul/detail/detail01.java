package developers.eunbyul.detail;


import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import db.DBService;
import db.DBServiceImpl;
import developers.eunbyul.detail.Controller.DetailController01;
import dto.MovieDTO;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class detail01 {
	DBService db = new DBServiceImpl();
	static String mv = "극장판 포켓몬스터: 정글의 아이, 코코";
	
	public void start()  {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/eunbyul/detail/fxmlPages/detail01.fxml"));
		Parent root=null;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			DetailController01 ctl = loader.getController();
			ctl.setRoot(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			DetailController01 dc = loader.getController();
			dc.setRoot(root);
			MovieDTO dto = db.selectSQL("극장판 포켓몬스터: 정글의 아이, 코코");
			this.mv = "극장판 포켓몬스터: 정글의 아이, 코코";
			Label movieTitle = (Label) root.lookup("#movieTitle");
			Label movieDate = (Label) root.lookup("#movieDate");
			Label movieInfomation = (Label) root.lookup("#movieInfomation");
			Label movieNation = (Label) root.lookup("#movieNation");
			Label movieDirector = (Label) root.lookup("#movieDirector");
			Label movieActor = (Label) root.lookup("#movieActor");
			Label movieFilmrate = (Label) root.lookup("#movieFilmrate");
			Label movieRunningtime = (Label)root.lookup("#movieRunningtime");
			try {
				SimpleDateFormat trimDate = new SimpleDateFormat("yy-MM-dd");
				Date d;
	
				d = trimDate.parse(dto.getMovieDate());
				String newDate = trimDate.format(d);
	
				movieTitle.setText(dto.getTitle());
				movieDate.setText(newDate);
				movieInfomation.setText(dto.getInfomation());
				movieNation.setText(dto.getNation());
				movieDirector.setText(dto.getDirector());
				movieActor.setText(dto.getActor());
				movieFilmrate.setText(dto.getFilmRate());
				movieRunningtime.setText(dto.getRunningTime() + "분");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		///////////////////////////////////////////
		
	}
}
