package View;

import Controller.HomeController;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;


public class HomeGUI extends Pane {

    public HomeGUI(Stage mainStage) {
        Stage stage = mainStage;
        HomeController hc = new HomeController(stage);

        final URL resource = getClass().getResource("/audio/clank.wav");
//        System.out.println(resource);
        final AudioClip clip = new AudioClip(resource.toString());


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
        tt1.setOnFinished(e -> hc.playClank());
//        tt1.play();

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), bottom);
        tt2.setFromY(300);
        tt2.setToY(140);
        tt2.setOnFinished(e -> hc.playClank());
//        tt2.play();

        SequentialTransition sequentialTransition = new SequentialTransition(tt1, tt2);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(e -> hc.playMeadow());

        TranslateTransition ttmelee = new TranslateTransition(Duration.seconds(3), melee);
        ttmelee.setToX(300);
        ttmelee.play();


        TranslateTransition ttmeadows = new TranslateTransition(Duration.seconds(3), meadows);
        ttmeadows.setToX(-500);
        ttmeadows.play();


        Button next = new Button("Click to Start");
        next.setTranslateY(200);
        next.setTranslateX(200);
        next.setOpacity(0);
        next.setOnMouseClicked(e -> hc.next());

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), next);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDelay(Duration.seconds(3));
        fadeTransition.play();



        this.getChildren().addAll(top, bottom, melee, meadows, next);

    }
}
