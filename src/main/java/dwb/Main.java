
package dwb;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderMenu = new FXMLLoader(getClass().getClassLoader().getResource("graphismeMenu.fxml"));
		FXMLLoader loaderGame = new FXMLLoader(getClass().getClassLoader().getResource("graphismeJeu.fxml"));
		FXMLLoader loaderGame2 = new FXMLLoader(getClass().getClassLoader().getResource("graphismeJeuLvl2.fxml"));
		Parent rootMenu = loaderMenu.load();
		Parent rootGame = loaderGame.load();
		Parent rootGame2 = loaderGame2.load();
		
		MenuControlleur controlleurMenu = (MenuControlleur) loaderMenu.getController();
		ControlleurJeu controlleurGame = (ControlleurJeu) loaderGame.getController();
		ControlleurJeu2 controlleurGame2 = (ControlleurJeu2) loaderGame2.getController();
		controlleurMenu.setControlerGame(controlleurGame);
		controlleurMenu.setControlerGame2(controlleurGame2);

		
		Scene sceneMenu = new Scene(rootMenu);
		Scene sceneGame = new Scene(rootGame);
		Scene sceneGame2 = new Scene(rootGame2);
		//Scene sceneGame2 = new Scene(rootGame2);
		
		sceneMenu.getStylesheets().add("fichierStyle.css");
		sceneGame.getStylesheets().add("fichierStyle.css");
		sceneGame2.getStylesheets().add("fichierStyle.css");

/////////////////////////////deplacement//////////////////////////////////////////////
		sceneGame.setOnKeyReleased((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				controlleurGame.deplacementRealesed(event);
			}

		});
		
		sceneGame2.setOnKeyReleased((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				controlleurGame2.deplacementRealesed(event);
			}

		});

		sceneGame.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				controlleurGame.deplacementPressed(event);
				controlleurGame.exitPressed(event);
			}

		});
		
		sceneGame2.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				controlleurGame2.deplacementPressed(event);
				controlleurGame2.exitPressed(event);
			}

		});

/////////////////////////////////////////////////////////////////////////////////////

		controlleurMenu.setPrimaryStage(primaryStage);

		controlleurMenu.setSceneGame(sceneGame);
		
		controlleurMenu.setSceneGame2(sceneGame2);

		String title = "Dream World Battle";
		primaryStage.getIcons()
				.add(new Image(getClass().getClassLoader().getResourceAsStream("image/spriteJoueur.png")));
		primaryStage.setTitle(title);
		primaryStage.setScene(sceneMenu);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
