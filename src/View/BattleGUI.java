package View;

import Controller.BattleController;
import Model.Monster;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import Controller.ChosenController;
import Model.Monster;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class BattleGUI extends GridPane {
    Stage stage;
    Monster first;
    Monster second;
    ImageView firstImage;
    ImageView secondImage;
    Button back = new Button();
    RoomGUI roomGUI;
    public BattleGUI(Stage s, Monster firstMon, Monster secondMon, RoomGUI roomGUI) {

        BattleController bc = new BattleController(s, firstMon, secondMon, this, roomGUI);

        stage = s;
        first = firstMon;
        second = secondMon;
        firstImage = bc.findImage(first);
        secondImage = bc.findImage(second);
        this.roomGUI = roomGUI;

        Label t = new Label("VS");

        this.setGridLinesVisible(true);
//        this.getColumnConstraints().add(new ColumnConstraints(250));
//        this.getRowConstraints().add(new RowConstraints(250));
        this.setPadding(new Insets(30,60,0,60));
        this.add(t, 2,1);
        this.add(firstImage, 0, 1);
        this.add(secondImage, 4, 1);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(13);
        ColumnConstraints col3 = new ColumnConstraints();
        col2.setPercentWidth(14);
        ColumnConstraints col4 = new ColumnConstraints();
        col2.setPercentWidth(13);
        ColumnConstraints col5 = new ColumnConstraints();
        col3.setPercentWidth(30);
        this.getColumnConstraints().addAll(col1, col2, col3, col4, col5);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(30);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(30);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(40);
        this.getRowConstraints().addAll(row1, row2, row3);
//        this.getColumnConstraints().add(new ColumnConstraints(250));

//        back.setText("Congrats on the win! Return to game");
//        back.setOnAction(e -> bc.back());

//        this.add(back, 0, 1, 2, 1);

        bc.battler();

    }

    public Button getBack() {
        return back;
    }

}












