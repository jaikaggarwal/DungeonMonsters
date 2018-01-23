package View;

import Controller.ThirdRoomController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class ThirdRoomGUI extends RoomGUI {
    public ThirdRoomGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);

        ThirdRoomController trc = new ThirdRoomController(stage, this, m);
        trc.populate();
        ImageView monsterImage = trc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = trc.moveUp();
                        break;
                    case DOWN:
                        update = trc.moveDown();
                        break;
                    case RIGHT:
                        update = trc.moveRight();
                        break;
                    case LEFT:
                        update = trc.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    trc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        stage.setTitle("Room 3");
    }
}


