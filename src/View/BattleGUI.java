package View;

import Controller.BattleController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import Controller.ChosenController;
import Model.Monster;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class BattleGUI extends Pane {
    Stage stage;
    Monster first;
    Monster second;
    ImageView firstImage;
    ImageView secondImage;
//    Button back = new Button();
    RoomGUI roomGUI;
    int OPTION_Y = 220;
    int ATTACK_X = 60;
    int DEFEND_X = 220;
    int RUN_X = 370;
    int ARROW_X = 310;
    int ARROW_Y = 180;
    ImageView arrow;
    Rectangle menusbg;
    Rectangle menubg;
    Label attack;
    Label defend;
    Label run;


    public BattleGUI(Stage s, Monster firstMon, Monster secondMon, RoomGUI roomGUI) {

        BattleController bc = new BattleController(s, firstMon, secondMon, this, roomGUI);

        stage = s;
        first = firstMon;
        second = secondMon;

        firstImage = bc.findImage(first);
        firstImage.setX(50);
        firstImage.setY(80);
        secondImage = bc.findImage(second);
        secondImage.setX(340);
        secondImage.setY(90);

        menusbg = new Rectangle(0, 190, 500, 85);
        menusbg.setId("menusbg");
        menubg = new Rectangle(10, 200, 480, 65);
        menubg.setId("menubg");

        this.roomGUI = roomGUI;

        attack = new Label("ATTACK");
        attack.setTranslateY(OPTION_Y);
        attack.setTranslateX(ATTACK_X);
        defend = new Label("DEFEND");
        defend.setTranslateY(OPTION_Y);
        defend.setTranslateX(DEFEND_X);
        run = new Label("RUN");
        run.setTranslateY(OPTION_Y);
        run.setTranslateX(RUN_X);

        arrow = new ImageView(new Image("images/arrow.png", 100, 100, false, false));
        arrow.setX(ARROW_X);
        arrow.setY(ARROW_Y);

        arrow.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        bc.arrowMoveRight();
                        break;

                    case LEFT:
                        bc.arrowMoveLeft();
                        break;

                    case ENTER:
                        //bc.battleStatus();
                        bc.determineMove();
                }
            }
        });
        arrow.setFocusTraversable(true);

        this.setPadding(new Insets(30,60,0,60));
        this.getChildren().addAll(firstImage, secondImage, menusbg, menubg, attack, defend, run, arrow);



//
//        bc.startBattle();

    }

//    public Button getBack() {
//        return back;
//    }

    public ImageView getArrow() {
        return arrow;
    }

    public ImageView getFirstImage() {
        return firstImage;
    }

    public ImageView getSecondImage() {
        return secondImage;
    }

    public Rectangle getMenusbg(){
        return this.menusbg;
    }
    public Rectangle getMenubg(){
        return this.menubg;
    }

    public Label getAttack() {
        return attack;
    }

    public Label getDefend(){
        return defend;
    }

    public Label getRun() {
        return run;
    }
}












