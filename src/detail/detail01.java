package detail;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import db.DBService;
import detail.Controller.DetailController01;
import dto.MovieDTO;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class detail01 {
	DBService db = new DBService();

	public void start() {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/detail/fxmlPages/detail01.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		DetailController01 ctl = loader.getController();
		ctl.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		///////////////////////////////////////////
		MovieDTO dto = db.selectSQL("보이스");

		DetailController01 dc = loader.getController();
		dc.setRoot(root);

		Label movieTitle = (Label) root.lookup("#movieTitle");
		Label movieDate = (Label) root.lookup("#movieDate");
		Label movieInfomation = (Label) root.lookup("#movieInfomation");
		Label movieNation = (Label) root.lookup("#movieNation");
		Label movieDirector = (Label) root.lookup("#movieDirector");
		Label movieActor = (Label) root.lookup("#movieActor");
		Label movieFilmrate = (Label) root.lookup("#movieFilmrate");
		Label movieRunningtime = (Label) root.lookup("#movieRunningtime");

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

	}

	public static void main(String[] args) {
		// launch(args);
	}

}
