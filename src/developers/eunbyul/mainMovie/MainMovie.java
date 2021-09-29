package developers.eunbyul.mainMovie;

import db.DBService;
import db.DBServiceImpl;
import dto.MovieDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMovie{
	DBService db = new DBServiceImpl();
	MovieDTO dto = db.selectSQL(null);
	
	
	public void start(Parent root){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/eunbyul/mainMovie/mainMovie.fxml"));
		Parent viewroot = null;
		try{
			viewroot = loader.load();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(viewroot);
		Stage s = (Stage) root.getScene().getWindow();
		MainController ctl = loader.getController();
		ctl.setRoot(root);
		s.setScene(scene);
		s.show();
	}

}
