package dwb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlleurWin  extends ControlleurMere implements Initializable{

    private Stage primaryStage;
    private Scene sceneMenu;
    public void setSceneMenu(Scene sceneMenu) {
        this.sceneMenu = sceneMenu;
    }
    


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    @FXML
    Button Start;


    @FXML
    Button back;

    public void HandleStart() throws IOException {
        primaryStage.setScene(sceneMenu);
    	
    }

    @FXML
    private void HandleBack() {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	System.out.println("scene rejouer");
    }
}
