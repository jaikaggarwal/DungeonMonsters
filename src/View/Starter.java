package View;

import Model.FireMonster;
import Model.WaterMonster;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class    Starter extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {}

    @Override
    public void start(Stage mainStage) throws Exception {

//        Scene scene = new Scene(new HomeGUI(mainStage), 500, 275);
//        mainStage.setScene(scene);
//        mainStage.show();

//        Scene scene = new Scene(new FirstRoomGUI(mainStage, new WaterMonster()));
//        mainStage.setScene(scene);
//        mainStage.show();

        Scene scene = new Scene(new IntroGUI(mainStage), 500, 275);
        scene.getStylesheets().add("Styles/introStyle.css");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
