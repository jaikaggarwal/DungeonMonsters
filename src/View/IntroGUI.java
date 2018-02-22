package View;

import Controller.IntroController;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class IntroGUI extends Pane{
    public IntroGUI(Stage mainStage){
        int SCROLL_WIDTH = 450;
        int SCROLL_HEIGHT = 400;
        int SCROLL_SEPARATION = 400;
        IntroController ic = new IntroController(mainStage);

        ImageView scroll_1 = new ImageView(new Image("images/scroll_1.png", SCROLL_WIDTH, SCROLL_HEIGHT, false, false));
        ImageView scroll_2 = new ImageView(new Image("images/scroll_2.png", SCROLL_WIDTH, SCROLL_HEIGHT, false, false));
        ImageView scroll_3 = new ImageView(new Image("images/scroll_3.png", SCROLL_WIDTH, SCROLL_HEIGHT, false, false));
        scroll_2.setY(SCROLL_SEPARATION);
        scroll_3.setY(SCROLL_SEPARATION * 2 + 18);
        scroll_1.setX(25);
        scroll_2.setX(25);
        scroll_3.setX(25);

        TranslateTransition tts1 = new TranslateTransition(Duration.seconds(35), scroll_1);
        tts1.setFromY(300);
        tts1.setToY(-800);
        tts1.play();

        TranslateTransition tts2 = new TranslateTransition(Duration.seconds(37), scroll_2);
        tts2.setFromY(300);
        tts2.setToY(-900);
        tts2.play();

        TranslateTransition tts3 = new TranslateTransition(Duration.seconds(37), scroll_3);

        tts3.setFromY(300);
        tts3.setToY(-940);
        tts3.play();
        tts3.setOnFinished(e -> ic.next());



        this.getChildren().addAll(scroll_1, scroll_2, scroll_3);





    }
}
