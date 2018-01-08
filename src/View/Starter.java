package View;

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
        Scene scene = new Scene(new MonsterChoiceGUI(mainStage), 500, 275);
        scene.getStylesheets().add("Styles/MonsterChoiceStyle.css");
//        Scene scene = new Scene(new HomeGUI(mainStage), 500, 275);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
