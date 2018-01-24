package Controller;

import Model.Monster;
import View.FirstDungeonGUI;
import View.RoomGUI;
import View.SecondRoomGUI;
import View.ThirdRoomGUI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ThirdRoomController extends RoomController{
    public ThirdRoomController(Stage s, ThirdRoomGUI r, Monster m){
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
                if (j == 6 && i ==6){
                    ImageView iv = new ImageView(new Image("images/dungeon_entry.png", WIDTH, HEIGHT, false, false));
                    ImageView iv2 = new ImageView(grass);
                    cols.add("DE");
                    room.add(iv2, j, i);
                    room.add(iv, j, i);
                }
                else if ((j == 9 || j == 3 || i == 3 || i == 9)) {
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
//        monster.setHealth(monster.getHealth()*2);
//        room.add(new ImageView(boss), 9, 0);
//        rows.get(0).set(1, "boss");
    }

    @Override
    public boolean moveUp(){
        if ((monster.getX() == 9 || monster.getX() == 3) && monster.getY() == 0){
            monster.setY(rowNum - 1);
            Scene scene = new Scene(new SecondRoomGUI(stage, monster), 500, 275);
            stage.setScene(scene);
            return false;
        }
        else if (!(monster.getY() - 1 < 0)){
            monster.setY(monster.getY() - 1);
        }
        return true;
    }
    @Override
    public void updateLocation(){
        if (monster.getX() == 6 && monster.getY() == 6){
            monster.setY(rowNum - 1);
            Scene scene = new Scene(new FirstDungeonGUI(stage, monster), 500, 275);
            stage.setScene(scene);
        }
        room.getChildren().remove(iv);
        room.add(iv, monster.getX(), monster.getY());
        battleSim();
    }
}



