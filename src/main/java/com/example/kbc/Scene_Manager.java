package com.example.kbc;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Scene_Manager {
    private Stage stage;
    public Scene_Manager(Stage stage){
        this.stage = stage;
    }
    public void switchScene(Scene scene){
        stage.setScene(scene);
        FadeTransition fade = new FadeTransition(Duration.millis(80), stage.getScene().getRoot());
        fade.setFromValue(1);
        fade.setToValue(0);

        fade.setOnFinished(e -> {
            stage.setScene(scene);

            FadeTransition fadeIn = new FadeTransition(Duration.millis(80), scene.getRoot());
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        });

        fade.play();
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
    }
    public Stage getStage(){
        return stage;
    }
}
