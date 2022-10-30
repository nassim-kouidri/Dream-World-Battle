package dwb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.print.attribute.standard.Media;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;

public class MenuControlleur implements Initializable {

	private Stage primaryStage;
	private Scene sceneGame;
	private Scene sceneGame2;
	private ControlleurJeu controlerGame;
	private ControlleurJeu2 controlerGame2;

	public void setControlerGame(ControlleurJeu controlerGame) {
		this.controlerGame = controlerGame;
	}
	
	public void setControlerGame2(ControlleurJeu2 controlerGame2) {
		this.controlerGame2 = controlerGame2;
	}

	// To change Scene
	@FXML
	Button Start;

	@FXML
	Button Back;

	// To quit game
	@FXML
	Button exit;
	
	@FXML
	Button lvl2;

//	@FXML
//	private MediaPlayer mp;
//
//	@FXML
//	private Media me;

	Boolean fenetreJeu = false;

	AudioClip mediaPlayer = new AudioClip(this.getClass().getResource("test.wav").toString());


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setSceneGame(Scene sceneGame) {
		this.sceneGame = sceneGame;
	}
	
	public void setSceneGame2(Scene sceneGame2) {
		this.sceneGame2 = sceneGame2;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mediaPlayer.play();

	}

	public void HandleStart() throws IOException {
		mediaPlayer.stop();
		primaryStage.setScene(sceneGame);
		fenetreJeu = true;
		controlerGame.init();
		primaryStage.centerOnScreen();
		primaryStage.setHeight(900);
		primaryStage.setWidth(1200);
	}
	
	public void HandleLvl2() throws IOException {
		mediaPlayer.stop();
		primaryStage.setScene(sceneGame2);
		fenetreJeu = true;
		controlerGame2.init();
		primaryStage.centerOnScreen();
		primaryStage.setHeight(900);
		primaryStage.setWidth(1200);
	}

	public void HandleBack() throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("graphismeMenu.fxml"));
		Stage window = (Stage) Back.getScene().getWindow();
		window.setScene(new Scene(root));
	}

	@FXML
	private void closeButtonAction() {
		// get a handle to the stage
		Stage stage = (Stage) exit.getScene().getWindow();
		// do what you have to do
		mediaPlayer.stop();
		stage.close();
		
	}

}