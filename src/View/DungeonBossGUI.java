package View;

import Controller.DungeonBossController;
import Controller.FirstDungeonController;
import Controller.RoomController;
import Model.Monster;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class DungeonBossGUI extends RoomGUI{
    Stage mainStage;
    Monster monster;
    DungeonBossController dbc;
    public DungeonBossGUI(Stage stage, Monster m) {
        this.setAlignment(Pos.CENTER);
        this.setBackground(Background.EMPTY);
        this.setGridLinesVisible(true);
        this.setHgap(0);
        this.setVgap(0);
        mainStage = stage;
        monster = m;
        dbc = new DungeonBossController(mainStage, this, monster);
        dbc.populate();
        ImageView monsterImage = dbc.getIv();

        monsterImage.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                boolean update = false;
                switch (event.getCode()) {
                    case UP:
                        update = dbc.moveUp();
                        break;
                    case DOWN:
                        update = dbc.moveDown();
                        break;
                    case RIGHT:
                        update = dbc.moveRight();
                        break;
                    case LEFT:
                        update = dbc.moveLeft();
                        break;
                    default:
                        break;
                }
                if (update) {
                    dbc.updateLocation();
                }
            }
        });

        monsterImage.setFocusTraversable(true);

        mainStage.setTitle("Dungeon Boss");
    }
    @Override
    public RoomController getController() {
        return dbc;
    }
    public String getName(){
        return "dunBoss";
    }
}

