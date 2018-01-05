package View;

import Controller.FirstRoomController;
import Controller.SecondRoomController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SecondRoomGUI extends RoomGUI {
    public SecondRoomGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);

        SecondRoomController src = new SecondRoomController(stage, this, m);
        src.populate();
        ImageView monsterImage = src.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        src.moveUp();
                        System.out.println("Helo");
                        break;
                    case DOWN:
                        src.moveDown();
                        System.out.println("pole");
                        break;
                    case RIGHT:
                        src.moveRight();
                        System.out.println("weird");
                        break;
                    case LEFT:
                        src.moveLeft();
                        System.out.println("Cap");
                        break;
                    default:
                        System.out.println("How did you get here?");
                        break;
                }
                src.updateLocation();
            }
        });

        monsterImage.setFocusTraversable(true);

        stage.setTitle("Room 1");
    }
    }
