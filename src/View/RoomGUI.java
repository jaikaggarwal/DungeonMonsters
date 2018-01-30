package View;

import Controller.RoomController;
import javafx.scene.layout.GridPane;

public abstract class RoomGUI extends GridPane {
    public abstract RoomController getController();
    public abstract String getName();
}
