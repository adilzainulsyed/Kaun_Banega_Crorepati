package com.example.kbc.scenes;

import com.example.kbc.KBCGame;
import com.example.kbc.Scene_Manager;
import com.example.kbc.components.Label_Styler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Welcome_Scene {
    private Scene_Manager manager;

    public Welcome_Scene(Scene_Manager manager){
        this.manager = manager;
    }
    public Scene createScene(){
        KBCGame kbcGame = new KBCGame();
        VBox welcome_layout_verti = new VBox(20);
        HBox welcome_layout_hori = new HBox(30);
        VBox welcome_layout = new VBox(20);

        Image logo = new Image(getClass().getResource("/res/logo.png").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setX(700);
        logoView.setY(100);

        Label_Styler welcome = new Label_Styler("Welcome to Kaun Banega Crorepati!","title");
        Label_Styler creds = new Label_Styler("Made by: Adil Zainul Syed", "text");
        Label_Styler powered = new Label_Styler("Powered by:", "title");

        welcome_layout_verti.getChildren().addAll(logoView, welcome,creds,powered);
        welcome_layout_verti.setAlignment(Pos.CENTER);

        Label_Styler sponsor1 = new Label_Styler("MicroLoft","text");
        Label_Styler sponsor2 = new Label_Styler("PineApple","text");
        Label_Styler sponsor3 = new Label_Styler("BlackStone","text");
        Label_Styler sponsor4 = new Label_Styler("Phylyps","text");
        Label_Styler sponsor5 = new Label_Styler("TCS","text");

        welcome_layout_hori.getChildren().addAll(sponsor1,sponsor2,sponsor3,sponsor4,sponsor5);
        welcome_layout_hori.setAlignment(Pos.CENTER);

        Button next_scene1 = new Button("Go to Rules -> ");
        next_scene1.setOnAction(e-> {
            Rules_Scene rulesScene = new Rules_Scene(manager);
            manager.switchScene(rulesScene.createScene());
        });
        welcome_layout.getChildren().addAll(welcome_layout_verti,welcome_layout_hori,next_scene1);
        welcome_layout.setAlignment(Pos.CENTER);
        String bgPath = getClass().getResource("/res/background.jpg").toExternalForm();
        welcome_layout.setStyle(
                "-fx-background-image: url('" + bgPath + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );
        return new Scene(welcome_layout, 1500, 700);
    }
}
