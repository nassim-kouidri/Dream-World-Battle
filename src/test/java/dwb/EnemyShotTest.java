package dwb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

public class EnemyShotTest {

	@Test
	void testCoordinatesDefined() {
		//arrange
		AnchorPane root = new AnchorPane();
		Joueur player = new Joueur(50, 50, 96.00, 89.00, 0, 3, 2);
		Ennemi enemy = new Ennemi(100, 100, 128.00, 128.00);
		Pair<Double, Double> expectedPair;
		EnemyShot enemyShot = new EnemyShot(root, enemy.getX(), enemy.getY(), player.getX(), player.getY(), 100);
		
	
		//act
		enemyShot.initPath(enemy.getX(), enemy.getY(), player.getX(), player.getY(), 100);
		expectedPair = new Pair<Double, Double>(75.0, 75.0);
		
		//assert
		assertEquals(expectedPair, enemyShot.getCoordinates().get(50));
		
		
	}
}
