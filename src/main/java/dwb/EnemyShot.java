package dwb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

public class EnemyShot {

	private Image image;

	private ImageView v;
	private ArrayList<ImageView> projectilesEView = new ArrayList<ImageView>();
	
	private LinkedList<Pair<Double, Double>> coordinates;

	public void initPath(double enemyX, double enemyY, double playerX, double playerY, int interval) {
		Pair<Double, Double> enemyXY = new Pair<Double, Double>(enemyX, enemyY);
		Pair<Double, Double> playerXY = new Pair<Double, Double>(playerX, playerY);
		coordinates = new LinkedList<>();
		coordinates.add(enemyXY);
		double deltaX = (enemyX - playerX)/interval;
		double deltaY = (enemyY - playerY)/interval;
		double currentX = enemyX;
		double currentY = enemyY;
		for (double i=0;i<interval;i++) {
			currentX = currentX - deltaX;
			currentY = currentY - deltaY;
			coordinates.add(new Pair<Double, Double>(currentX, currentY));
		}
		coordinates.add(playerXY);
	}
	
	public EnemyShot(AnchorPane root, double enemyX, double enemyY, double playerX, double playerY, int interval) {
		
		image = new Image(getClass().getResource("/image/bullet.png").toExternalForm());
		v = new ImageView(image);
		v.relocate(enemyX + 60, enemyY);
		root.getChildren().add(v);
	}
	
	public ImageView getV() {
		return v;
	}

	public LinkedList<Pair<Double, Double>> getCoordinates() {
		return coordinates;
	}
}
