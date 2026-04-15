package com.example.kbc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.lang.invoke.LambdaConversionException;

public class KBCGame extends Application {

    @Override
    public void start(Stage stage) {
        // layouts
        //VBOX
        VBox welcome_layout = new VBox(10);


        //  Scene 1 : welcome screen
        Image logo = new Image(getClass().getResource("/res/logo.jpg").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setX(700);
        logoView.setY(100);

        Label welcome = new Label("Welcome to Kaun Banega Crorepati!");
        welcome.setStyle(
                "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 35px;"+
                "-fx-text-fill: linear-gradient(#ffd700, #ffb300);" + // gold gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, gold, 20, 0.1, 0, 0);" // glow
        );

        Label creds = new Label("Made by: Adil Zainul Syed");
        creds.setStyle(
                "-fx-font-family: 'Georgia';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#ffd700, #ffb300);" + // gold gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, gold, 20, 0.1, 0, 0);" // glow
        );

        welcome_layout.getChildren().addAll(logoView, welcome,creds);
        welcome_layout.setAlignment(Pos.CENTER);
        welcome_layout.setStyle("-fx-background-color: #2d1642;");

        Scene welcome_scene = new Scene(welcome_layout, 1500, 700);

        stage.setTitle("Kaun Banega Crorepati!");
        stage.setScene(welcome_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}