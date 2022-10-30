package dwb;

import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ControlleurMere {

	public boolean goLeft, goRight, goUp, goDown, isShooting;
	public BulletMethods bulletMethods;
	int score;

	String txtScore;
	int vie;
	String txtVie;
	
	@FXML
	protected Label scoreDisp;

	@FXML
	protected Label vieDisp;
	
	@FXML
	public AnchorPane root;

	@FXML
	public ImageView image;
	Timer chronoPlayer = new Timer();

	public Joueur joueur = new Joueur(320.00, 730.00, 96.00, 89.00, 0, 16, 0);
	protected Ennemi ennemi = new Ennemi(88, 64, 128.00, 128.00);
	protected double currentPosPlayerX;
	protected double currentPosPlayerY;
	protected Boolean playerInvincible = false;

	public void exitPressed(KeyEvent e) {
		switch (e.getCode()) {
		case ESCAPE:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public void deplacementPressed(KeyEvent e) {
		switch (e.getCode()) {
		case LEFT:
			goLeft = true;
			break;
		case RIGHT:
			goRight = true;
			break;
		case UP:
			goUp = true;
			break;
		case DOWN:
			goDown = true;
			break;
		case SPACE:
			if (!isShooting) {
				bulletMethods.shoot(root, joueur.getX(), joueur.getY());
				isShooting = true;
				break;
			}
		default:
			break;
		}
	};

	public void deplacementRealesed(KeyEvent e) {
		switch (e.getCode()) {
		case LEFT:
			goLeft = false;
			break;
		case RIGHT:
			goRight = false;
			break;
		case DOWN:
			goDown = false;
			break;
		case UP:
			goUp = false;
			break;
		case SPACE:
			isShooting = false;
			break;
		default:
			break;
		}

	};

	protected void handleAnimation() {
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				if (goLeft) {
					joueur.setX(joueur.getX() - 5);
				}
				if (goRight) {
					joueur.setX(joueur.getX() + 5);
				}
				if (goUp) {
					joueur.setY(joueur.getY() - 5);
				}
				if (goDown) {
					joueur.setY(joueur.getY() + 5);
				}

				bulletMethods.handleShootPlayer(root);
				

				image.setLayoutX(joueur.getX());
				image.setLayoutY(joueur.getY());
				joueur.getHitbox().setLayoutX(joueur.getX());
				joueur.getHitbox().setLayoutY(joueur.getY());
			}
		};
		timer.start();
	}

}
