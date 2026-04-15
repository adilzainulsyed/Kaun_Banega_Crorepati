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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Rules_Scene {
    private Scene_Manager manager;

    Rules_Scene(Scene_Manager manager){
        this.manager = manager;
    }

    public Scene createScene(){
        VBox rules_layout = new VBox(20);
        Label_Styler rules1 = new Label_Styler("1. No Cheating","text");
        Label_Styler rules2 = new Label_Styler("2. Follow rule 1 (pls)","text");
        Label_Styler rules3 = new Label_Styler("3. You have 4 life lines : \n i) Phone a friend\n ii) 50/50\n iii) Expert Advice\n iv) Flip the Question","text");
        Label_Styler rules4 = new Label_Styler("4. Maintain Decorum. Try not to laugh.","text");

        rules_layout.getChildren().addAll(rules1, rules2,rules3,rules4);
        rules_layout.setAlignment(Pos.CENTER);
        String bgPath2 = getClass().getResource("/res/background.jpg").toExternalForm();
        rules_layout.setStyle(
                "-fx-background-image: url('" + bgPath2 + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );
        return new Scene(rules_layout, 1500, 700);
    }


}
