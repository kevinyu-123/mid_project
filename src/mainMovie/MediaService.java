package mainMovie;

import javafx.scene.Parent;

public interface MediaService {
	public void myStart();
	public void myStop();
	public void myPause();
	public void setMedia(Parent root, String mediaName);
	}