package mainMovie;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.stage.Stage;

public class MainController implements Initializable {

	Parent root;
	Button btn01 = new Button();
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void gotoDetail( ActionEvent event ) {
		
		System.out.println("디테일페이지로");
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("movieDetail.fxml"));
		Parent viewroot=null;
		try {
			viewroot = loader.load();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		Scene scene = new Scene(viewroot);
		Stage s = (Stage)root.getScene().getWindow();
		s.setScene(scene);
		s.show();
             
       }
		  

	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
