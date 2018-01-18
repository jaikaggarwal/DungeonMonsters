package View;
import Controller.FirstRoomController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;

public class FirstRoomGUI extends RoomGUI {
    public FirstRoomGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);



        FirstRoomController frc = new FirstRoomController(stage, this, m);
        frc.populate();
        ImageView monsterImage = frc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                    switch (event.getCode()) {
                        case UP:
                            update = frc.moveUp();
                            break;
                        case DOWN:
                            update = frc.moveDown();
                            break;
                        case RIGHT:
                            update = frc.moveRight();
                            break;
                        case LEFT:
                            update = frc.moveLeft();
                            break;
                        default:
                            break;
                    }
                if (update) {
                    frc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        stage.setTitle("Room 1");
    }
}

