package dwb;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class ControlleurJeu2  extends ControlleurMere implements Initializable {

	// private boolean goLeft, goRight, goUp, goDown, isShooting;

	Timer chrono = new Timer();

//	Timer chronoPlayer = new Timer();

//	int score;
//
//	String txtScore;
//	int vie;
//	String txtVie;

//	@FXML
//	private AnchorPane root;

//	@FXML
//	private Label scoreDisp;
//
//	@FXML
//	private Label vieDisp;

//	@FXML
//	private ImageView image;

	@FXML
	private ImageView imageEnnemi;

	PathTransition transition;

//	private Boolean playerInvincible = false;

	// private Joueur joueur = new Joueur(320.00, 730.00, 96.00, 89.00, 0, 16, 0);
//	private double currentPosPlayerX;
//	private double currentPosPlayerY;
	//private Ennemi ennemi = new Ennemi(88, 64, 128.00, 128.00);

//	private BulletMethods bulletMethods;

	public void initialize(URL location, ResourceBundle resources) {

		///// controlleur mere
		handleAnimation();
		///// controlleur mere

		ennemi.cheminImage = "/image/spriteMechant2.png";
		bulletMethods = new BulletMethods();

		image.setLayoutX(joueur.getX());
		image.setLayoutY(joueur.getY());

		ennemi.ImageCreation(root, ennemi.cheminImage);
		ennemi.getV().setLayoutX(334.00);
		ennemi.getV().setLayoutY(92.00);

		game();
	}

	public void init() {
		txtVie = " Vie(s): " + joueur.getVie();
		vieDisp.setText(txtVie);

		root.getChildren().add(ennemi.getHitboxEnnemi());

		root.getChildren().add(joueur.getHitbox());

		chrono.schedule(new TimerTask() {
			int time = 0;

			private Polygon polyline = new Polygon();

			@Override
			public void run() {

				time += 1;

				PathTransition transition = new PathTransition();
				System.out.println("Time : " + time);

				if (time == 1) {

					polyline.getPoints().addAll(new Double[] { 400.0, 0.0, -250.0, 0.0, });
					transition.setNode(ennemi.getV());
					transition.setDuration(Duration.seconds(8));
					transition.setPath(polyline);
					transition.setCycleCount(Animation.INDEFINITE);
					transition.setAutoReverse(false);

/////////////////////////////Transitions du hitbox//////////////////////////////////////////////				

					PathTransition hitBoxTransition = new PathTransition();
					hitBoxTransition.setNode(ennemi.getHitboxEnnemi());
					hitBoxTransition.setDuration(Duration.seconds(8));
					hitBoxTransition.setPath(polyline);
					hitBoxTransition.setCycleCount(Animation.INDEFINITE);
					hitBoxTransition.setAutoReverse(false);

//////////////////////////////Jouer les transitions/////////////////////////////////////////////
					transition.play();
					hitBoxTransition.play();

				} else {

					Platform.runLater(() -> {

						if (ennemi.getHitboxEnnemi() != null) {

							bulletMethods.shootE(root, ennemi.v.getLayoutX(), ennemi.v.getLayoutY(), joueur.getX(),
									joueur.getY());
							currentPosPlayerX = joueur.getX();
							currentPosPlayerY = joueur.getY();
						}

					});

				}

			}

		}, 0, 1000);

	}

	public void game() {
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
		
		bulletMethods.handleShootEnemy(root, ennemi.getX(), ennemi.getY(), currentPosPlayerX, currentPosPlayerY);

		if (ennemi.getHitboxEnnemi() != null && bulletMethods.getProjectile() != null) {
			
			if (bulletMethods.collision(bulletMethods.getProjectile(), ennemi.getHitboxEnnemi())) {
				ennemi.v.setVisible(false);
				root.getChildren().remove(ennemi.getHitboxEnnemi());
				ennemi.setHitboxEnnemi(null);

				score = joueur.getScore() + 16;
				txtScore = " Score: " + score;
				joueur.setScore(score);
				scoreDisp.setText(txtScore);

				root.getChildren().remove(bulletMethods.getProjectile());
			}
		}

		if (joueur.getHitbox() != null && bulletMethods.getV() != null && playerInvincible == false) {
			if (bulletMethods.collision(bulletMethods.getV(), joueur.getHitbox())) {
				vie = joueur.getVie() - 1;
				txtVie = " Vie(s): " + vie;
				joueur.setVie(vie);
				vieDisp.setText(txtVie);
				playerInvincible = true;
				System.out.println("invincible");

				chronoPlayer.schedule(new TimerTask() {

					double timeP = 0;
					Boolean blink = true;
					int tmp = 2;
					Boolean sysBlink = true;

					@Override
					public void run() {
						timeP += 0.250;
						if (timeP == 3) {
							playerInvincible = false;
							System.out.println("vulnerable");
							sysBlink = false;
							image.setVisible(true);
							timeP = 0;
							return;
						}

						if (sysBlink == true) {
							if (blink == true) {

								image.setVisible(false);
							} else {
								image.setVisible(true);
							}

							if (tmp % 2 == 0) {
								blink = true;
							} else {
								blink = false;
							}
							tmp++;
						}

					}
				}, 0, 250);
			}
		}
			}
		};
		timer.start();
	}

}