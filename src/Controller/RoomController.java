package Controller;

import Model.*;
import View.BattleGUI;
import View.RoomGUI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class RoomController{
    Stage stage;
    Monster monster;
    RoomGUI room;
    ImageView iv = new ImageView();
    int HEIGHT = 25;
    int WIDTH = 50;
    int colNum = 10;
    int rowNum = 11;
    Image grass = new Image("images/grassSprite.jpg", WIDTH, HEIGHT, false, false);
    Image path = new Image("images/path.jpg", WIDTH, HEIGHT, false, false);
    Image boss = new Image("images/boss.jpg", WIDTH, HEIGHT, false, false);
    ArrayList<ArrayList<String>> rows = new ArrayList<>();


    public abstract void populate();
//        int i;
//        int j;
//
//        for (i = 0; i < rowNum; i++){
//            ArrayList<String> cols = new ArrayList<>();
//            for (j = 0; j < colNum; j++){
//                if ((j == 3 || j == 6 || i == 3 || i == 8) && (j > 2 && i > 2)) {
//                    ImageView iv = new ImageView(path);
//                    cols.add("path");
//                    room.add(iv, j, i);
//                } else {
//                    ImageView iv = new ImageView(grass);
//                    cols.add("grass");
//                    room.add(iv, j, i);
//                }
//            }
//            rows.add(cols);
//        }
//        iv = placeMonster();
//        monster.setHealth(monster.getHealth()*2);
//        room.add(new ImageView(boss), 9, 0);
//        rows.get(0).set(9, "boss");
//    }

    public ImageView placeMonster(){
        ImageView monImage = new ImageView();
        switch (monster.getOriginalName()){
            case "Fire Monster":
                monImage.setImage(new Image("images/fmon.jpg", WIDTH, HEIGHT, false, false));
                break;
            case "Water Monster":
                monImage.setImage(new Image("images/wmon.jpg", WIDTH, HEIGHT, false, false));
                break;
            case "Grass Monster":
                monImage.setImage(new Image("images/gmon.jpg", WIDTH, HEIGHT, false, false));
        }
        room.add(monImage, monster.getX(), monster.getY());
        return monImage;
    }

    public boolean battleChecker(){
        boolean check = false;
        if (rows.get(monster.getY()).get(monster.getX()).equals("grass")){
            check = Grass.checker();
        }
        return check;
    }

    public String battleType(){
        String type;
        switch (rows.get(monster.getY()).get(monster.getX())) {
            case "grass":
                type = "grass";
                break;
            case "boss":
                type = "boss";
                break;
            default:
                type = "none";
        }
        return type;
    }

    public Monster enemyGenerator() {
        Monster enemy;
        double typeCheck = Math.random();
        if (typeCheck < 0.33) {
            enemy = new WaterMonster();
        } else if (typeCheck < 0.67) {
            enemy = new FireMonster();
        } else {
            enemy = new GrassMonster();
        }
        return enemy;
    }

    public void battleSim(){
        String battleType = battleType();
        if (battleType.equals("grass")) {
            if (Grass.checker()) {
                Monster enemy = enemyGenerator();
                Scene scene = new Scene(new BattleGUI(stage, monster, enemy, room), 500, 275);
                scene.getStylesheets().add("Styles/battleStyle.css");
                stage.setScene(scene);
            }
        } else if (battleType.equals("boss")) {
            Monster enemy = new BossMonster();
            Scene scene = new Scene (new BattleGUI(stage, monster, enemy, room), 500, 275);
            scene.getStylesheets().add("Styles/battleStyle.css");
            stage.setScene(scene);
        }
    }

    public void moveLeft(){
        if (!(monster.getX() - 1 < 0)){
            monster.setX(monster.getX() - 1);
        }
    }

    public void moveRight(){
        if (monster.getX() < colNum - 1){
            monster.setX(monster.getX() + 1);
        }
    }
    public void moveUp(){
        if (!(monster.getY() - 1 < 0)){
            monster.setY(monster.getY() - 1);
        }
    }
    public void moveDown(){
        if (monster.getY() < rowNum - 1){
            monster.setY(monster.getY() + 1);
        }
    }

    public void updateLocation(){
        room.getChildren().remove(iv);
        room.add(iv, monster.getX(), monster.getY());
        battleSim();
    }

    public ImageView getIv() {
        return iv;
    }
}


