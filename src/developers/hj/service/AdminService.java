package developers.hj.service;

import javafx.scene.Parent;

public interface AdminService {
	public void setRoot(Parent root);
	public void login();
	public void viewMem();
	public void addMovie();
	public void updMoive();
	public void deleteMovie();
	public void resrvInfo();
	public void viewOneMem();
	public void viewAllMem();
	public void find();
	public void movieSave();
	public void searchMovie();
	public void confirmDelete();
	public void findId();
	public void findDelId();
	public void showResvInfo();
	public void cancelResv();
	public void confirmCancel();
	
}
