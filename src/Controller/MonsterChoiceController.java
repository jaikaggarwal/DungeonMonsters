package Controller;

import Model.FireMonster;
import Model.GrassMonster;
import Model.WaterMonster;
import View.ChosenGUI;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonsterChoiceController {

    Stage stage;

    public MonsterChoiceController(Stage s){
        stage = s;
    }

    public void createFireMonster(){
        Scene scene = new Scene (new ChosenGUI(stage, new FireMonster()), 500, 275);
        scene.getStylesheets().add("Styles/ChosenStyle.css");
        stage.setScene(scene);
    }

    public void createWaterMonster(){
        Scene scene = new Scene (new ChosenGUI(stage, new WaterMonster()), 500, 275);
        scene.getStylesheets().add("Styles/ChosenStyle.css");
        stage.setScene(scene);
    }
    public void createGrassMonster(){
        Scene scene = new Scene (new ChosenGUI(stage, new GrassMonster()), 500, 275);
        scene.getStylesheets().add("Styles/ChosenStyle.css");
        stage.setScene(scene);
    }
}
