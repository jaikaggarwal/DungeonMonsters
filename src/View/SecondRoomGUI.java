package View;

import Controller.FirstRoomController;
import Controller.RoomController;
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
    Stage mainStage;
    Monster monster;
    SecondRoomController src;
    public SecondRoomGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);

        mainStage = stage;
        monster = m;
        src = new SecondRoomController(mainStage, this, monster);
        src.populate();
        ImageView monsterImage = src.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = src.moveUp();
                        break;
                    case DOWN:
                        update = src.moveDown();
                        break;
                    case RIGHT:
                        update = src.moveRight();
                        break;
                    case LEFT:
                        update = src.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    src.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        mainStage.setTitle("Room 2");
    }
    @Override
    public RoomController getController() {
        return src;
    }
    public String getName(){
        return "second";
    }
}
