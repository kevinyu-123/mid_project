package mainMovie;


import java.net.URL;



import java.util.ResourceBundle;

import db.DBService;
import detail.detail01;
import detail.detail02;
import detail.detail03;
import detail.detail04;
import detail.detail05;
import detail.detail06;
import detail.detail07;
import detail.detail08;
import detail.detail09;
import detail.detail10;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class MainController implements Initializable {

	Parent root;
	DBService db;

	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void gotoDetail01(  ) {
		detail01 d = new detail01();
		d.start();
		System.out.println("디테일페이지로01");
	
       }
	public void gotoDetail02( ) {
		detail02 d2 = new detail02();
		d2.start();
		System.out.println("디테일페이지로02");
		
       }
	public void gotoDetail03( ActionEvent event ) {
		detail03 d = new detail03();
		d.start();
		System.out.println("디테일페이지로03");
		
       }
	public void gotoDetail04( ActionEvent event ) {
		detail04 d = new detail04();
		d.start();
		System.out.println("디테일페이지로04");
       }
	public void gotoDetail05( ActionEvent event ) {
		detail05 d = new detail05();
		d.start();
		System.out.println("디테일페이지로05");
		
       }
	public void gotoDetail06( ActionEvent event ) {
		detail06 d = new detail06();
		d.start();
		System.out.println("디테일페이지로06");
		
       }
	public void gotoDetail07( ActionEvent event ) {
		detail07 d = new detail07();
		d.start();
		System.out.println("디테일페이지로07");
		
       }
	public void gotoDetail08( ActionEvent event ) {
		detail08 d = new detail08();
		d.start();
		System.out.println("디테일페이지로08");
	
       }
	public void gotoDetail09( ActionEvent event ) {
		detail09 d = new detail09();
		d.start();
		System.out.println("디테일페이지로09");
		
       }
	public void gotoDetail10( ActionEvent event ) {
		detail10 d = new detail10();
		d.start();
		System.out.println("디테일페이지로10");
		
       }
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBService();
		
	}
	
}
