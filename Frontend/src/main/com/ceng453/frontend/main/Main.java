package main.com.ceng453.frontend.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        Main.primaryStage = stage;
        stage.setTitle("Amazing Game");

        initializeMusic();

        startMainPage(stage);

    }

    private void startMainPage(Stage stage) throws java.io.IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../pagecontrollers/Index.fxml"));
        Scene scene = new Scene(root, ApplicationConstants.ScreenWidth, ApplicationConstants.ScreenHeight);
        stage.setScene(scene);
        stage.show();
    }

    private void initializeMusic() {
        String musicFile = ApplicationConstants.GameMusicFilename;     // For example
        Media sound = new Media(new File(System.getProperty("user.dir") + "/assets/" + musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        MediaView mediaView = new MediaView(mediaPlayer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
