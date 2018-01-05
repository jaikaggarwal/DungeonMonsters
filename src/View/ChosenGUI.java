package View;

import Controller.ChosenController;
import Model.Monster;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ChosenGUI extends GridPane {
    Monster monster;
    TextField textField;
    public ChosenGUI(Stage s, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);

        this.setBackground(Background.EMPTY);

        ChosenController cc = new ChosenController(s, m, this);
        monster = m;
        Label t = new Label();
        Image image = null;

        Button back = new Button();
        back.setText("Choose again");
        back.setOnAction(e -> cc.back());

        Button next = new Button();
        next.setText("Start your adventure!");
        next.setOnAction(e -> cc.next());

        switch (monster.getName()){
            case "Fire Monster":
                t.setText("You chose a fire monster!");
                // image taken from http://monster-match.wikia.com/wiki/File:182_fire_jackal_B.png
                image = new Image("images/fmon.jpg", 100, 100, false, false);
                break;
            case "Water Monster":
                t.setText("You chose a water monster!");
                //image taken from http://monsterlegends.wikia.com/wiki/File:Turtle-3.png
                image = new Image("images/wmon.jpg", 100, 100, false, false);
                break;
            case "Grass Monster":
                t.setText("You chose a grass monster!");
                // image taken from https://kurosakikeroro.deviantart.com/art/grass-monster-2-401081973
                image = new Image("images/gmon.jpg", 100, 100, false, false);
                break;
        }
        if (image != null) {
            ImageView iv = new ImageView(image);
            this.add(iv, 0, 1);
        }

        textField = new TextField();
        textField.setText("Name your monster!");
        textField.setOnMouseClicked(e -> cc.newType());
        textField.setOnKeyPressed(e -> cc.updateName(e.getCode(), textField.getText()));
        this.add(t,1,0, 2, 1);
        this.add(back, 1, 1);
        this.add(next, 1, 2);
//        this.setPadding(new Insets(20,20,20,20));
//        this.getRowConstraints().add(new RowConstraints(100));
        this.add(textField, 0, 2);

        s.setTitle("Congratulations!");
//        this.setGridLinesVisible(true);
    }

    public TextField getTextField(){
        return this.textField;
    }
}
