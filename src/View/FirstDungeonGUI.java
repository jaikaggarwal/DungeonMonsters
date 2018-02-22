package View;

import Controller.FirstDungeonController;
import Controller.RoomController;
import Controller.SecondRoomController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class FirstDungeonGUI extends RoomGUI{
    Stage mainStage;
    Monster monster;
    FirstDungeonController fdc;
    public FirstDungeonGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);
        mainStage = stage;
        monster = m;
        fdc = new FirstDungeonController(mainStage, this, monster);
        fdc.populate();
        ImageView monsterImage = fdc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = fdc.moveUp();
                        break;
                    case DOWN:
                        update = fdc.moveDown();
                        break;
                    case RIGHT:
                        update = fdc.moveRight();
                        break;
                    case LEFT:
                        update = fdc.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    fdc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        mainStage.setTitle("First Dungeon");
    }
    @Override
    public RoomController getController() {
        return fdc;
    }
    public String getName(){
        return "dun1";
    }
}


