package View;

import Controller.RoomController;
import Controller.SecondDungeonController;
import Controller.ThirdDungeonController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class ThirdDungeonGUI extends RoomGUI {
    Stage mainStage;
    Monster monster;
    ThirdDungeonController tdc;
    public ThirdDungeonGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);
        mainStage = stage;
        monster = m;
        tdc = new ThirdDungeonController(mainStage, this, monster);
        tdc.populate();
        ImageView monsterImage = tdc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = tdc.moveUp();
                        break;
                    case DOWN:
                        update = tdc.moveDown();
                        break;
                    case RIGHT:
                        update = tdc.moveRight();
                        break;
                    case LEFT:
                        update = tdc.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    tdc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        mainStage.setTitle("Third Dungeon");
    }
    @Override
    public RoomController getController() {
        return tdc;
    }
    public String getName(){
        return "dun3";
    }
}
