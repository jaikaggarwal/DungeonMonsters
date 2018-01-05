package Controller;

import Model.Battle;
import Model.Monster;
import View.BattleGUI;
import View.FirstRoomGUI;
import View.MonsterChoiceGUI;
import View.RoomGUI;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class BattleController {
    Monster first;
    Monster second;
    Stage stage;
    BattleGUI battleGUI;
    RoomGUI roomGUI;

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
        Battle.battle(first, second);
        if (first.getHealth() <= 0){
            battleGUI.getBack().setText("Looks like you lost!");
            battleGUI.getBack().setOnAction(e -> gameOver());
        } else {
            battleGUI.getBack().setText("Congrats you won!");
            battleGUI.getBack().setOnAction(e -> back());
        }
        battleGUI.add(battleGUI.getBack(), 1,2, 2,1);
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

}
