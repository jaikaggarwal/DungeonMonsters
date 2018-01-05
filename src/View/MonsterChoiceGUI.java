package View;

import Controller.MonsterChoiceController;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class MonsterChoiceGUI extends GridPane {
    public MonsterChoiceGUI(Stage stage) {
        this.setAlignment(Pos.CENTER);
        this.setHgap(30);
        this.setBackground(Background.EMPTY);

        MonsterChoiceController mcc = new MonsterChoiceController(stage);

        ImageView fireLogo = new ImageView(new Image("images/fire.jpg", 100, 100, false, false));
        ImageView waterLogo = new ImageView(new Image("images/water.jpg", 120, 120, false, false));
        ImageView grassLogo = new ImageView(new Image("images/grass.jpg",    100, 100, false, false));


        fireLogo.setOnMouseClicked(e -> mcc.createFireMonster());
        waterLogo.setOnMouseClicked(e -> mcc.createWaterMonster());
        grassLogo.setOnMouseClicked(e -> mcc.createGrassMonster());



        this.add(fireLogo,0,0);
        this.add(waterLogo,2,0);
        this.add(grassLogo,4,0);

        stage.setTitle("Choose the type of your monster!");


    }
}
