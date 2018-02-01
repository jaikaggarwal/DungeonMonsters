package View;

import Controller.FirstDungeonController;
import Controller.RoomController;
import Controller.SecondDungeonController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class SecondDungeonGUI extends RoomGUI {
    Stage mainStage;
    Monster monster;
    SecondDungeonController sdc;
    public SecondDungeonGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);
        mainStage = stage;
        monster = m;
        sdc = new SecondDungeonController(mainStage, this, monster);
        sdc.populate();
        ImageView monsterImage = sdc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = sdc.moveUp();
                        break;
                    case DOWN:
                        update = sdc.moveDown();
                        break;
                    case RIGHT:
                        update = sdc.moveRight();
                        break;
                    case LEFT:
                        update = sdc.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    sdc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        mainStage.setTitle("Second Dungeon");
    }
    @Override
    public RoomController getController() {
        return sdc;
    }
    public String getName(){
        return "dun2";
    }
}

