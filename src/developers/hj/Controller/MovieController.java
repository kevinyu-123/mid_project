package developers.hj.Controller;

import java.net.URL;

import java.util.ResourceBundle;

import common.DBCommon;
import developers.hj.service.AdminService;
import developers.hj.service.AdminServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MovieController implements Initializable {
	Parent root;
	AdminService as;
	
	public void setRoot(Parent root) {
		this.root = root;
		as.setRoot(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DBCommon.setDBConnection();
		as = new AdminServiceImpl();
		
	}
	public void movieSave() {
		as.movieSave();
	}
	public void searchMovie() {
		as.searchMovie();
	}
	
	public void delete() {
		as.confirmDelete();
	}

}
