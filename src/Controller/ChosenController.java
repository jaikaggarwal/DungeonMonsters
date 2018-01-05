package Controller;

import Model.Monster;
import View.ChosenGUI;
import View.FirstRoomGUI;
import View.MonsterChoiceGUI;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ChosenController {

    Stage stage;
    Monster monster;
    ChosenGUI chosenGUI;

    public ChosenController(Stage s, Monster m, ChosenGUI cgui){
        stage = s;
        monster = m;
        chosenGUI = cgui;
    }

    public void back(){
        Scene scene = new Scene(new MonsterChoiceGUI(stage), 500, 275);
        scene.getStylesheets().add("Styles/MonsterChoiceStyle.css");
        stage.setScene(scene);
    }

    public void next(){
        monster.setHealth(monster.getHealth()*2);
        Scene scene = new Scene(new FirstRoomGUI(stage, monster), 500, 275);
        stage.setScene(scene);
    }

    public void updateName(KeyCode keyCode, String text) {
        if (keyCode.equals(KeyCode.ENTER)){
            if (text.length() > 0) {
                monster.setName(text);
                System.out.println(monster.getName());
                chosenGUI.getTextField().clear();
            } else {
                System.out.println("Need to input a name!");
            }
        }
    }

    public void newType(){
        chosenGUI.getTextField().getStyleClass().add("text-field-black");
        chosenGUI.getTextField().clear();
    }

}
