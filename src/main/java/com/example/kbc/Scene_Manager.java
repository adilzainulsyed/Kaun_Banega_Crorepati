package com.example.kbc;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scene_Manager {
    private Stage stage;
    public Scene_Manager(Stage stage){
        this.stage = stage;
    }
    public void switchScene(Scene scene){
        stage.setScene(scene);
    }
    public Stage getStage(){
        return stage;
    }
}
