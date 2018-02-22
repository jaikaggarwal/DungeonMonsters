package Controller;

import Model.Monster;
import View.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SecondDungeonController extends RoomController {
    Image wall = new Image("images/dungeon_wall.png", WIDTH, HEIGHT, false, false);
    Image d_path = new Image("images/dungeon_path.png", WIDTH, HEIGHT, false, false);
    Image d_stairs = new Image("images/dungeon_stairs.png", WIDTH, HEIGHT, false, false);

    public SecondDungeonController(Stage s, SecondDungeonGUI r, Monster m) {
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
                if (j < 3 || j > 6) {
                    ImageView iv = new ImageView(wall);
                    cols.add("wall");
                    room.add(iv, j, i);
                } else {
                    ImageView iv = new ImageView(d_path);
                    cols.add("d_path");
                    room.add(iv, j, i);
                }
            }
            rows.add(cols);
        }
        iv = placeMonster();
        if (!treasure_opened_2) {
            room.add(treasure, 4, 0, 2, 2);
            rows.get(0).set(5, "treasure");
            rows.get(0).set(4, "treasure");
            rows.get(1).set(4, "treasure");
            rows.get(1).set(5, "treasure");
        }
        ImageView imageView = new ImageView(d_stairs);
        room.add(imageView, 3, rowNum - 1);

    }

    @Override
    public boolean moveLeft() {
        if (!(monster.getX() - 1 < 3)) {
            monster.setX(monster.getX() - 1);
        }
        return true;
    }

    @Override
    public boolean moveRight() {
        if (monster.getX() < 6) {
            monster.setX(monster.getX() + 1);
        }
        return true;
    }

    @Override
    public void updateLocation(){
        if (monster.getX() == 3 && monster.getY() == rowNum - 1){
            monster.setY(0);
            monster.setX(8);
            Scene scene = new Scene(new SecondRoomGUI(stage, monster), 500, 275);
            stage.setScene(scene);
        }
        room.getChildren().remove(iv);
        room.add(iv, monster.getX(), monster.getY());
        battleSim();
    }
}

