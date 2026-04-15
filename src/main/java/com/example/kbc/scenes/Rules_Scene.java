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

public class Rules_Scene {
    private Scene_Manager manager;

    Rules_Scene(Scene_Manager manager){
        this.manager = manager;
    }

    public Scene createScene(){
        BorderPane root = new BorderPane();
        VBox rules_layout = new VBox(20);

        Button back_button = new Button("<- Go Back");
        back_button.setOnAction(
                e -> {
                    Welcome_Scene welcome_scene = new Welcome_Scene(manager);
                    manager.switchScene(welcome_scene.createScene());
                }
        );

        Label_Styler rules1 = new Label_Styler("1. No Cheating","title");
        Label_Styler rules2 = new Label_Styler("2. Follow rule 1 (pls)","title");
        Label_Styler rules3 = new Label_Styler("3. You have 4 life lines : \n \ti) Phone a friend\n \tii) 50/50\n \tiii) Expert Advice\n \tiv) Flip the Question","title");
        Label_Styler rules4 = new Label_Styler("4. Maintain Decorum.","title");
        Label_Styler rules5 = new Label_Styler("5. Try not to laugh.","title");

        Button start_button = new Button("Let's Start?");
        back_button.setOnAction(
                e -> {
                    Questions_Scene questions_scene = new Questions_Scene(manager);
                    manager.switchScene(questions_scene.createScene());
                }
        );

        rules_layout.getChildren().addAll(rules1, rules2,rules3,rules4, rules5, start_button);
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
        return new Scene(root, 1500, 700);
    }


}
