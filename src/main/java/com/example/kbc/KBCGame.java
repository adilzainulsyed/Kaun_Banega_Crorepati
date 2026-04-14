package com.example.kbc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class KBCGame extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello KBC!");

        Scene scene = new Scene(label, 400, 300);

        stage.setTitle("Kaun Banega Crorepati!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}