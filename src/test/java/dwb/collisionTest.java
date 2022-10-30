package dwb;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.shape.Rectangle;

public class collisionTest {

	@Test
	void testCollisionTrue() {
		//arrange
		
		BulletMethods collision = new BulletMethods();
		Rectangle hitboxEnnemi = new Rectangle();
		Rectangle tir = new Rectangle();
		
		//act
		
		collision.collision(hitboxEnnemi, tir);
		hitboxEnnemi.setWidth(5);
		hitboxEnnemi.setHeight(5);
		tir.setWidth(5);
		tir.setHeight(5);
		
		hitboxEnnemi.setLayoutX(32);
		hitboxEnnemi.setLayoutY(32);
		tir.setLayoutX(32);
		tir.setLayoutY(32);
		
		//assert
		
		assertEquals(true, collision.collision(tir, hitboxEnnemi));	
		
		
		
	}
	
	@Test
	void testCollisionFalse() {
		//arrange
		
		BulletMethods collision = new BulletMethods();
		Rectangle hitboxEnnemi = new Rectangle();
		Rectangle tir = new Rectangle();
		
		//act
		
		collision.collision(hitboxEnnemi, tir);
		hitboxEnnemi.setWidth(5);
		hitboxEnnemi.setHeight(5);
		tir.setWidth(5);
		tir.setHeight(5);
		
		hitboxEnnemi.setLayoutX(32);
		hitboxEnnemi.setLayoutY(50);
		tir.setLayoutX(32);
		tir.setLayoutY(16);
		
		//assert
		
		assertEquals(false, collision.collision(tir, hitboxEnnemi));	
		
	}
	
}
