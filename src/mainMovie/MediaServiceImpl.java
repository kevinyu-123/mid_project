package mainMovie;


import detail.detail01;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class MediaServiceImpl implements MediaService {
	 Parent root;
	MediaPlayer mediaPlayer;
	 MediaView mediaView;
	Button btnPlay, btnStop, btnPause;
	
	
	
	@Override
	public void myPlay() {
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
		System.out.println("ddd");
		setControll(root);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		mediaPlayer.setOnReady(() -> {
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnPlaying(() -> {
			btnPlay.setDisable(true);
			btnStop.setDisable(false);
			btnPause.setDisable(false);
		});
		mediaPlayer.setOnStopped(() -> {
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnPaused(() -> {
			btnPlay.setDisable(false);
			btnStop.setDisable(false);
			btnPause.setDisable(true);
		});
		mediaPlayer.setOnEndOfMedia(() -> {
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
			myStop();
		});
	}

	public void setControll(Parent root) {
		mediaView = (MediaView) root.lookup("#fxMediaView");
		btnPlay = (Button) root.lookup("#btnPlay");
		btnStop = (Button) root.lookup("#btnStop");
		btnPause = (Button) root.lookup("#btnPause");

	}
		 
	}

