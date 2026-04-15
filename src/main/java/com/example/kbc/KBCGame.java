package com.example.kbc;

import com.example.kbc.scenes.Welcome_Scene;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.lang.invoke.LambdaConversionException;

public class KBCGame extends Application {

    @Override
    public void start(Stage stage) {
        Image logo = new Image(getClass().getResource("/res/logo.png").toExternalForm());
        Scene_Manager sceneManager = new Scene_Manager(stage);
        Welcome_Scene welcome_scene = new Welcome_Scene(sceneManager);

        stage.setTitle("Kaun Banega Crorepati!");
        stage.getIcons().add(logo);
        stage.setScene(welcome_scene.createScene());
        //stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}