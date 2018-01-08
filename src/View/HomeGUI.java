package View;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class HomeGUI extends Pane {
    Stage stage;

    public HomeGUI(Stage mainStage) {
        stage = mainStage;


        ImageView top = new ImageView(new Image("images/meadow_top.jpg", 500, 140, false, false));
        ImageView bottom = new ImageView(new Image("images/meadow_bottom.jpg", 500, 143, false, false));
        ImageView melee = new ImageView(new Image("images/melee.png", 900, 940, false, false));
        ImageView meadows = new ImageView(new Image("images/meadows.png", 900, 940, false, false));

        melee.setX(-600);
        melee.setY(-350);

        meadows.setX(300);
        meadows.setY(-300);

        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), top);
        tt1.setFromY(-100);
        tt1.setToY(0);
        tt1.play();

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), bottom);
        tt2.setFromY(300);
        tt2.setToY(140);
        tt2.play();

        TranslateTransition ttmelee = new TranslateTransition(Duration.seconds(3), melee);
        ttmelee.setToX(300);
        ttmelee.play();


        TranslateTransition ttmeadows = new TranslateTransition(Duration.seconds(3), meadows);
        ttmeadows.setToX(-500);
        ttmeadows.play();



        this.getChildren().addAll(top, bottom, melee, meadows);

    }
}
