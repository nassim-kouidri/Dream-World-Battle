module module {
	exports dwb;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;

	opens dwb to javafx.fxml;
}