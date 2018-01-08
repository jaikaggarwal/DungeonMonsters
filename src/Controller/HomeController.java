package Controller;

import View.MonsterChoiceGUI;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    Stage stage;

    public HomeController(Stage mainstage){
        stage = mainstage;
    }
    public void next() {
        Scene scene = new Scene(new MonsterChoiceGUI(stage), 500, 275);
        scene.getStylesheets().add("Styles/MonsterChoiceStyle.css");
        stage.setScene(scene);
    }
}
