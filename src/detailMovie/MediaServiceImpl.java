package detailMovie;


import javafx.scene.Parent;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaService{
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Button btnPlay, btnStop, btnPause;
	Label movieTitle, movieDate, movieInfomation,movieNation,movieDirector,
	movieActor,movieFilmrate;
	
	
	@Override
	public void myStart() {
		mediaPlayer.play();
	}
	@Override
	public void myStop() {
		mediaPlayer.stop();
	}
	@Override
	public void myPause() {
		mediaPlayer.pause();
	}
	@Override
	public void setMedia(Parent root, String mediaName) {
		setControll(root);
		Media media = new Media(getClass().getResource(mediaName).toString() );
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		mediaPlayer.setOnReady(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnPlaying(()->{
			
			btnPlay.setDisable(true);
			btnStop.setDisable(false);
			btnPause.setDisable(false);
			
	
		});
		mediaPlayer.setOnStopped(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(false);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnEndOfMedia(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
			myStop();
		});}
		private void setControll(Parent root) {
			mediaView = (MediaView)root.lookup("#fxMediaView");
			btnPlay = (Button)root.lookup("#btnPlay");
			btnStop = (Button)root.lookup("#btnStop");
			btnPause = (Button)root.lookup("#btnPause");
			
			movieTitle = (Label)root.lookup("#movieTitle");
			movieDate = (Label)root.lookup("#movieDate");
			movieInfomation = (Label)root.lookup("#movieInfomation");
			movieNation = (Label)root.lookup("#movieNation");
			movieDirector = (Label)root.lookup("#movieDirector");
			movieActor = (Label)root.lookup("#movieActor");
			movieFilmrate = (Label)root.lookup("#movieFilmrate");
	}

	
}





