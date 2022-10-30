package dwb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.util.Pair;
import dwb.EnemyShot;

@SuppressWarnings("unused")
public class BulletMethods {

	private Rectangle projectile;
	private EnemyShot enemyshot;
	private Image image;

	private ImageView v;

	private ArrayList<Rectangle> projectiles = new ArrayList<Rectangle>();
	private ArrayList<EnemyShot> projectilesE = new ArrayList<EnemyShot>();
	private LinkedList<Pair<Double, Double>> coordinates;

	private int projectileSpeed = 5;
	private int projectileSpeedE = 5;

	public void shoot(AnchorPane root, double x, double y) {
		projectiles.add(projectile = new Rectangle(5, 10, Color.BLACK));
		projectile.relocate(x + 45, y);
		root.getChildren().add(projectile);
	}

	public void handleShootPlayer(AnchorPane root) {
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).relocate(projectiles.get(i).getLayoutX(),
					(projectiles.get(i).getLayoutY() - projectileSpeed));
		}

		Iterator<Rectangle> iterator = projectiles.iterator();

		while (iterator.hasNext()) {
			projectile = iterator.next();
			if (projectile.getLayoutY() < 0) {

				iterator.remove();
				root.getChildren().remove(projectile);
				projectile = null;

			}
		}

	}

	public Rectangle getProjectile() {
		return projectile;
	}

	public boolean collision(Rectangle bullet, Rectangle hitBox) {

		if (bullet.getBoundsInParent().intersects(hitBox.getBoundsInParent())) {
			System.out.println("touch");

			return true;

		} else {
			return false;
		}

	}

	public boolean collision(ImageView bullet, Rectangle hitBox) {

		if (bullet.getBoundsInParent().intersects(hitBox.getBoundsInParent())) {
			System.out.println("touch");

			return true;

		} else {
			return false;
		}

	}

	public void shootE(AnchorPane root, double enemyX, double enemyY, double playerX, double playerY) {
		projectilesE.add(enemyshot = new EnemyShot(root, enemyX, enemyY, playerX, playerY, 100));
		enemyshot.initPath(enemyX, enemyY, playerX, playerY, 128);
	}

	public void handleShootEnemy(AnchorPane root, double ennemiX, double ennemiY, double joueurX, double joueurY) {
		for (int i = 0; i < projectilesE.size(); i++) {
			// faire avancer le projectile selon la trajectoire dfinie dans shootE

			if (projectilesE.get(i).getCoordinates().size() != 0) {
				projectilesE.get(i).getV().relocate(
						projectilesE.get(i).getCoordinates().get(0).getKey(),
						projectilesE.get(i).getCoordinates().get(0).getValue());
				projectilesE.get(i).getCoordinates().removeFirst();
			}				
		}

		Iterator<EnemyShot> iterator = projectilesE.iterator();

		while(iterator.hasNext())
		{
			enemyshot = iterator.next();
			if (enemyshot.getCoordinates().size() == 0) {
				iterator.remove();
				root.getChildren().remove(enemyshot.getV());
				System.out.println("balle enlevee");
				enemyshot = null;
			}
		}}


	public ImageView getV() {
		return v;
	}

	public void handleshootEnemy(AnchorPane root, double ennemiX, double ennemiY, double joueurX, double joueurY) {

		PathTransition transition = new PathTransition();
		Line line = new Line();
		line.setStartX(ennemiX + 350);
		line.setStartY(ennemiY + 150);
		line.setEndX(joueurX);
		line.setEndY(810);

		Image image = new Image(getClass().getResource("/image/bullet.png").toExternalForm());
		ImageView v = new ImageView(image);
		transition.setNode(v);
		transition.setDuration(Duration.seconds(3));
		transition.setPath(line);
		transition.setAutoReverse(false);
		transition.play();

		root.getChildren().add(v);

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
			root.getChildren().remove(v);
		}));
		timeline.play();

	}

}
