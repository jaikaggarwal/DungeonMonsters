package Controller;

import Model.*;
import View.BattleGUI;
import View.RoomGUI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

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
    Image boss = new Image("images/boss.jpg", WIDTH*2, HEIGHT*2, false, false);
    ImageView treasure = new ImageView(new Image("images/treasure.png", WIDTH*2, HEIGHT*2, false, false));
    ArrayList<ArrayList<String>> rows = new ArrayList<>();
    Random rnd = new Random();
    ArrayList password = new ArrayList<>();
    static boolean treasure_opened_1 = false;
    static boolean treasure_opened_2 = false;

    public abstract void populate();


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
        String battleType = rows.get(monster.getY()).get(monster.getX());
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
        } else if (battleType.equals("treasure")){
            int pass_int = rnd.nextInt(10);
            password.add(pass_int);
            room.getChildren().remove(treasure);
            if (room.getName() == "first") {
                room.getController().treasure_opened_1 = true;
            }
            if (room.getName() == "second") {
                room.getController().treasure_opened_2 = true;
            }
        }
    }

    public boolean moveLeft(){
        if (!(monster.getX() - 1 < 0)){
            monster.setX(monster.getX() - 1);
        }
        return true;
    }

    public boolean moveRight(){
        if (monster.getX() < colNum - 1){
            monster.setX(monster.getX() + 1);
        }
        return true;
    }
    public boolean moveUp(){
        if (!(monster.getY() - 1 < 0)){
            monster.setY(monster.getY() - 1);
        }
        return true;
    }
    public boolean moveDown(){
        if (monster.getY() < rowNum - 1){
            monster.setY(monster.getY() + 1);
        }
        return true;
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


