package Controller;

import Model.*;
import View.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class FirstRoomController extends RoomController {


    public FirstRoomController(Stage s, FirstRoomGUI r, Monster m) {
        stage = s;
        room = r;
        monster = m;
    }

    public void populate() {
        int i;
        int j;

        for (i = 0; i < rowNum; i++) {
            ArrayList<String> cols = new ArrayList<>();
            for (j = 0; j < colNum; j++) {
                if ((j == 3 || j == 6 || i == 3 || i == 8) && (j > 2 && i > 2)) {
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
        room.add(new ImageView(boss), 9, 0);
        rows.get(0).set(9, "boss");
    }

    @Override
    public boolean moveRight() {
        if (monster.getX() + 1 == colNum && (monster.getY() == 3 || monster.getY() == 8)) {
            monster.setX(0);
            Scene scene = new Scene(new SecondRoomGUI(stage, monster), 500, 275);
            stage.setScene(scene);
            return false;
        } else if (monster.getX() < colNum - 1) {
            monster.setX(monster.getX() + 1);
            return true;
        }
        return false;
    }
}
