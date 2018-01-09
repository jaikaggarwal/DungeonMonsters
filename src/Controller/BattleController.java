package Controller;

import Model.Battle;
import Model.Monster;
import View.BattleGUI;
import View.FirstRoomGUI;
import View.MonsterChoiceGUI;
import View.RoomGUI;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class BattleController {
    Monster first;
    Monster second;
    Stage stage;
    BattleGUI battleGUI;
    RoomGUI roomGUI;
    int SHIELD_SIZE = 400;

    public BattleController(Stage s, Monster monster, Monster enemy, BattleGUI bgui, RoomGUI rgui){
        first = monster;
        second = enemy;
        stage = s;
        battleGUI = bgui;
        roomGUI = rgui;
    }

    public ImageView findImage(Monster mon){
        ImageView monImage = new ImageView();
        switch (mon.getOriginalName()){
            case "Fire Monster":
                monImage.setImage(new javafx.scene.image.Image("images/fmon.jpg", 100, 100, false, false));
                break;
            case "Water Monster":
                monImage.setImage(new javafx.scene.image.Image("images/wmon.jpg", 100,  100, false, false));
                break;
            case "Grass Monster":
                monImage.setImage(new javafx.scene.image.Image("images/gmon.jpg", 100, 100, false, false));
                break;
            case "Boss Monster":
                monImage.setImage(new javafx.scene.image.Image("images/boss.jpg", 100, 100, false, false));
        }
        return monImage;
    }

    public void battler(){
        battleGUI.getArrow().setX(0);
        Battle.battle(first, second);
//        if (first.getHealth() <= 0){
//            battleGUI.getBack().setText("Looks like you lost!");
//            battleGUI.getBack().setOnAction(e -> gameOver());
//        } else {
//            battleGUI.getBack().setText("Congrats you won!");
//            battleGUI.getBack().setOnAction(e -> back());
//        }
//        battleGUI.getChildren().add(battleGUI.getBack());
        }

    public void back(){
        RoomGUI x;
        try {
            x = roomGUI.getClass().getConstructor(Stage.class, Monster.class).newInstance(stage, first);
            Scene scene = new Scene(x, 500, 275);
            stage.setScene(scene);
        } catch (Exception e){
            System.out.println("what just happened");
        }
    }

    public void gameOver(){
        Scene scene = new Scene(new MonsterChoiceGUI(stage), 500, 275);
        stage.setScene(scene);
    }

    public void arrowMoveLeft(){
        if (battleGUI.getArrow().getX() == 160) {
            battleGUI.getArrow().setX(0);
        } else if (battleGUI.getArrow().getX() == 310) {
            battleGUI.getArrow().setX(160);
        }
    }

    public void arrowMoveRight(){
        if (battleGUI.getArrow().getX() == 0) {
            battleGUI.getArrow().setX(160);
        } else if (battleGUI.getArrow().getX() == 160) {
            battleGUI.getArrow().setX(310);
        }
    }

    public void attack(){
        ImageView monImage = battleGUI.getFirstImage();
        TranslateTransition monMove = new TranslateTransition(Duration.seconds(0.2), monImage);
        monMove.setToX(150);
        monMove.setAutoReverse(true);
        monMove.setCycleCount(2);
        monMove.play();
    }

    public void defend(){
        ImageView shield = shieldtype();
        shield.setOpacity(0);
        shield.setX(-20);
        shield.setY(-70);
        FadeTransition shieldTrans = new FadeTransition(Duration.seconds(2), shield);
        shieldTrans.setToValue(1);
        shieldTrans.setOnFinished(e -> battleGUI.getChildren().remove(shield));
        shieldTrans.play();
        battleGUI.getChildren().add(shield);
    }

    public ImageView shieldtype(){
        ImageView shieldType;
        switch (first.getOriginalName()){
            case "Fire Monster":
                shieldType = new ImageView(new Image("images/fireShield.png", SHIELD_SIZE, SHIELD_SIZE, false, false));
                break;
            case "Water Monster":
                shieldType = new ImageView(new Image("images/waterShield.png", SHIELD_SIZE, SHIELD_SIZE, false, false));
                break;
            case "Grass Monster":
                shieldType = new ImageView(new Image("images/grassShield.png", SHIELD_SIZE, SHIELD_SIZE, false, false));
                break;
            default:
                shieldType = new ImageView(new Image("images/waterShield.png", SHIELD_SIZE, SHIELD_SIZE, false, false));
        }
        return shieldType;
    }

    public void determineMove(){
        switch ((int) battleGUI.getArrow().getX()){
            case 0:
                attack();
                break;
            case 160:
                defend();
                break;
            case 310:
                back();
        }
    }

}
