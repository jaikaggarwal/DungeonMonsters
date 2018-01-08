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
//        top.setFill(Color.INDIGO);
        ImageView bottom = new ImageView(new Image("images/meadow_bottom.jpg", 500, 143, false, false));
//        bottom.setFill(Color.MEDIUMVIOLETRED);
//        Rectangle check = new Rectangle(0, 275, 500, 1);

        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), top);
        tt1.setFromY(-100);
        tt1.setToY(0);
        tt1.play();

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), bottom);
        tt2.setFromY(300);
        tt2.setToY(140);
        tt2.play();

        this.getChildren().addAll(top, bottom);

    }
}
