package developers.soo.main;

import developers.soo.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainClass extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/soo/fxml/Main.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Font.loadFont(getClass().getResourceAsStream("/developers/soo/style/BebasNeue.otf"), 14);
        scene.getStylesheets().add(getClass().getResource("/developers/soo/style/main.css").toExternalForm());
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		arg0.setTitle("넛 플 릭 스");		// 타이틀 제목
		arg0.getIcons().add(new Image("/developers/soo/style/1111.PNG"));	// 넷플릭스 아이콘 설정
		arg0.setScene(scene);
		arg0.show();
//		new Scene(root)
	}
	public static void main(String[] args) {
		launch(args);
	}

}
