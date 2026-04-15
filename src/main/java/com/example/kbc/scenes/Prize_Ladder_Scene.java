package com.example.kbc.scenes;

import com.example.kbc.Scene_Manager;
import com.example.kbc.components.Label_Styler;
import javafx.css.Rule;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Prize_Ladder_Scene {
    private Scene_Manager manager;

    public Prize_Ladder_Scene(Scene_Manager manager){
        this.manager = manager;
    }
    public Scene createScene(){
        BorderPane root = new BorderPane();
        VBox rules_layout = new VBox(25);

        Button back_button = new Button("<- Go Back");
        back_button.setOnAction(
                e -> {
                    Rules_Scene rules_scene = new Rules_Scene(manager);
                    manager.switchScene(rules_scene.createScene());
                }
        );

        Label_Styler prizeladder_title = new Label_Styler("Prize Ladder","title");
        rules_layout.getChildren().add(prizeladder_title);

        String[] prizemoney = {"1,000", "5,000", "10,000", "50,000", "1,00,000", "10,00,000","25,00,000", "50,00,000","1,00,00,000","7,00,00,000" };
        for (int i = 0; i<=9;i++){
            String temp = "Que"+(i+1)+" -> ₹"+ prizemoney[i];
            rules_layout.getChildren().add(new Label_Styler(temp,"text"));
        }

        Button start_button = new Button("Let's Start?");
        start_button.setOnAction(
                e -> {
                    Questions_Scene questions_scene = new Questions_Scene(manager);
                    manager.switchScene(questions_scene.createScene());
                }
        );

        rules_layout.getChildren().add(start_button);
        rules_layout.setAlignment(Pos.CENTER);

        root.setTop(back_button);
        root.setCenter(rules_layout);
        BorderPane.setAlignment(back_button, Pos.TOP_LEFT);
        BorderPane.setAlignment(rules_layout, Pos.CENTER);


        String bgPath2 = getClass().getResource("/res/background.jpg").toExternalForm();
        root.setStyle(
                "-fx-background-image: url('" + bgPath2 + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );
        return new Scene(root,1500, 700);
    }
}
