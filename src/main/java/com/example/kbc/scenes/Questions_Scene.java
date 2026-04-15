package com.example.kbc.scenes;

import com.example.kbc.Scene_Manager;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Questions_Scene {
    private Scene_Manager manager;
    Questions_Scene(Scene_Manager manager){
        this.manager = manager;
    }
    public Scene createScene(){
        VBox root = new VBox(30);

        return new Scene(root, 1500, 700);
    }
}
