package com.example.kbc;

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
        // layouts
        //VBOX
        VBox welcome_layout_verti = new VBox(20);
        VBox welcome_layout = new VBox(20);

        //HBOX
        HBox welcome_layout_hori = new HBox(30);

        //  Scene 1 : welcome screen
        Image logo = new Image(getClass().getResource("/res/logo.png").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setX(700);
        logoView.setY(100);

        Label welcome = new Label("Welcome to Kaun Banega Crorepati!");
        welcome.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 35px;"+
                "-fx-text-fill: linear-gradient(#ffd700, #ffb300);" + // gold gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, gold, 20, 0.1, 0, 0);" // glow
        );

        Label creds = new Label("Made by: Adil Zainul Syed");
        creds.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        Label powered = new Label("Powered by:");
        powered.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#ffd700, #ffb300);" + // gold gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, gold, 20, 0.1, 0, 0);" // glow
        );

        welcome_layout_verti.getChildren().addAll(logoView, welcome,creds,powered);
        welcome_layout_verti.setAlignment(Pos.CENTER);

        Label sponsor1 = new Label("MicroLoft");
        sponsor1.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        Label sponsor2 = new Label("PineApple");
        sponsor2.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        Label sponsor3 = new Label("BlackStone");
        sponsor3.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        Label sponsor4 = new Label("Phylyps");
        sponsor4.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        Label sponsor5 = new Label("TCS");
        sponsor5.setStyle(
                "-fx-font-family: 'Verdana';" +
                        "-fx-font-size: 25px;"+
                        "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" + // white-grey gradient
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, grey, 20, 0.1, 0, 0);" // glow
        );

        welcome_layout_hori.getChildren().addAll(sponsor1,sponsor2,sponsor3,sponsor4,sponsor5);
        welcome_layout_hori.setAlignment(Pos.CENTER);

        Button next_scene1 = new Button("Go to Rules -> ");

        welcome_layout.getChildren().addAll(welcome_layout_verti,welcome_layout_hori,next_scene1);
        welcome_layout.setAlignment(Pos.CENTER);
        String bgPath = getClass().getResource("/res/background.jpg").toExternalForm();
        welcome_layout.setStyle(
                "-fx-background-image: url('" + bgPath + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );

        Scene welcome_scene = new Scene(welcome_layout, 1500, 700);

        stage.setTitle("Kaun Banega Crorepati!");
        stage.setScene(welcome_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}