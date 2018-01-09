package Controller;

import View.MonsterChoiceGUI;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.net.URL;

public class HomeController {
    Stage stage;
    AudioClip clip;

    public HomeController(Stage mainstage){
        stage = mainstage;
    }
    public void next() {
        Scene scene = new Scene(new MonsterChoiceGUI(stage), 500, 275);
        scene.getStylesheets().add("Styles/MonsterChoiceStyle.css");
        clip.stop();    
        stage.setScene(scene);
    }

    public void playClank(){
        URL sound = getClass().getResource("/audio/clank.wav");
        clip = new AudioClip(sound.toString());
        clip.play();
    }

    public void playMeadow(){
        URL sound = getClass().getResource("/audio/meadow.wav");
        clip = new AudioClip(sound.toString());
        clip.play();
    }
}
