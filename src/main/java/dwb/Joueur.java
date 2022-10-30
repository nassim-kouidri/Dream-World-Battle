package dwb;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joueur {

	private double x;
	private double y;
	private double dimensionX;
	private double dimensionY;
	private int score;
	private int vie;
	private int puissance;
	private Rectangle hitbox;
	
	public Joueur(double x, double y, double dimensionX, double dimensionY, int score, int vie, int puissance) {
		this.x = x;
		this.y = y;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.x = x;
		this.y = y;
		this.score = score;
		this.vie = vie;
		this.puissance = puissance;
		hitbox = new Rectangle(getDimensionX(), getDimensionY());
		hitbox.setStroke(Color.BEIGE);
		hitbox.setFill(Color.DARKBLUE);
		hitbox.setOpacity(0.5);
		hitbox.setVisible(false);
		hitbox.setLayoutX(getDimensionX());
		hitbox.setLayoutY(getDimensionY());
		
	}
	
	


	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}




	public double getX() {
		return x;
	}

	public void setX(double x) {
		if (x != -20 && x != 720) {
			this.x = x;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		if (y != 770 && y != -10) {
			this.y = y;
		}
	}

	public int getScore() {
		return score;
	}

	public int getVie() {
		return vie;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
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
