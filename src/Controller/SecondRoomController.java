package Controller;

import Model.Monster;
import View.FirstRoomGUI;
import View.SecondRoomGUI;
import javafx.scene.Scene;
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
                if ((j == 4 || j == 3 || i == 3 || i == 8)) {
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
        monster.setHealth(monster.getHealth()*2);
        room.add(new ImageView(boss), 9, 0);
        rows.get(0).set(9, "boss");
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

}
