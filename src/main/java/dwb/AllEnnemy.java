package dwb;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class AllEnnemy {
	
	protected String cheminImage;
	protected Image image;
	protected ImageView v;

	protected void ImageCreation(AnchorPane root, String cheminImage) {
		
		image = new Image(getClass().getResource(cheminImage).toExternalForm());
		v = new ImageView(image);
		
		root.getChildren().add(v);

	}

	public Image getImage() {
		return image;
	}



	public ImageView getV() {
		return v;
	}



	public void setImage(Image image) {
		this.image = image;
	}



	public void setV(ImageView v) {
		this.v = v;
	}



	public String getCheminImage() {
		return cheminImage;
	}
	
	public String setCheminImage(String cheminImage) {
		return this.cheminImage = cheminImage;
	}
}



