package dwb;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ennemi extends AllEnnemy{

	private double x;
	private double y;
	private double dimensionX;
	private double dimensionY;
	private Rectangle hitboxEnnemi;
	
	public Ennemi(double x, double y, double dimensionX, double dimensionY) {
		this.x = x;
		this.y = y;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		hitboxEnnemi = new Rectangle(getDimensionX(), getDimensionY());
		hitboxEnnemi.setStroke(Color.ORANGERED);
		hitboxEnnemi.setVisible(false);
		hitboxEnnemi.setOpacity(0.5);
		hitboxEnnemi.setLayoutX(334.00);
		hitboxEnnemi.setLayoutY(92.00);
	}
	
	

	public Rectangle getHitboxEnnemi() {
		return hitboxEnnemi;
	}



	public void setHitboxEnnemi(Rectangle hitboxEnnemi) {
		this.hitboxEnnemi = hitboxEnnemi;
	}



	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		if (x != -20 && x != 720) {
			this.x = x;
		}
	}

	public void setY(double y) {
		if (y != 770 && y != -10) {
			this.y = y;
		}
	}

	public double getDimensionX() {
		return dimensionX;
	}

	public double getDimensionY() {
		return dimensionY;
	}

	public void setDimensionX(double dimensionX) {
		this.dimensionX = dimensionX;
	}

	public void setDimensionY(double dimensionY) {
		this.dimensionY = dimensionY;
	}
	
	
	


}
