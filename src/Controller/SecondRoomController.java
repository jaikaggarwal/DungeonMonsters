package Controller;

import Model.Monster;
import View.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SecondRoomController extends RoomController {

    public SecondRoomController(Stage s, SecondRoomGUI r, Monster m){
        stage = s;
        room = r;
        monster = m;
    }

    public void populate(){
        int i;
        int j;

        for (i = 0; i < rowNum; i++){
            ArrayList<String> cols = new ArrayList<>();
            for (j = 0; j < colNum; j++){
                if (j == 9 && i == 0){
                    ImageView iv = new ImageView(new Image("images/dungeon_entry.png", WIDTH, HEIGHT, false, false));
                    ImageView iv2 = new ImageView(grass);
                    cols.add("DE");
                    room.add(iv2, j, i);
                    room.add(iv, j, i);
                } else if (((j == 3 && i > 2) || (j == 9 && i > 2) || i == 3 || i == 8)) {
                    ImageView iv = new ImageView(path);
                    cols.add("path");
                    room.add(iv, j, i);
                } else {
                    ImageView iv = new ImageView(grass);
                    cols.add("grass");
                    room.add(iv, j, i);
                }
            }
            rows.add(cols);
        }
        iv = placeMonster();


    }

    @Override
    public boolean moveLeft(){
        if (monster.getX() == 0 && (monster.getY() == 3 || monster.getY() == 8)){
            monster.setX(colNum - 1);
            Scene scene = new Scene(new FirstRoomGUI(stage, monster), 500, 275);
            stage.setScene(scene);
            return false;
        }
        else if (monster.getX() > 0){
            monster.setX(monster.getX() - 1);
        }
        return true;
    }

    @Override
    public boolean moveDown(){
        if ((monster.getX() == 9 || monster.getX() == 3) && monster.getY() == 10){
            monster.setY(0);
            Scene scene = new Scene(new ThirdRoomGUI(stage, monster), 500, 275);
            stage.setScene(scene);
            return false;
        }
        else if (monster.getY() < rowNum - 1){
            monster.setY(monster.getY() + 1);
        }
        return true;
    }
    @Override
    public void updateLocation() {
        if (monster.getX() == 9 && monster.getY() == 0) {
            monster.setY(rowNum - 1);
            monster.setX(4);
            Scene scene = new Scene(new SecondDungeonGUI(stage, monster), 500, 275);
            stage.setScene(scene);
        }
        room.getChildren().remove(iv);
        room.add(iv, monster.getX(), monster.getY());
        battleSim();
    }
}
