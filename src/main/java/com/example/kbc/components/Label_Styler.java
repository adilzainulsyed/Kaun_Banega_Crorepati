package com.example.kbc.components;

import javafx.scene.control.Label;

public class Label_Styler extends Label {
    public Label_Styler(String text, String type){
        super(text);

        if (type.equals("title")) {
            setStyle(
                    "-fx-font-family: 'Verdana';" +
                            "-fx-font-size: 35px;" +
                            "-fx-text-fill: linear-gradient(#ffd700, #ffb300);" +
                            "-fx-font-weight: bold;" +
                            "-fx-effect: dropshadow(gaussian, gold, 20, 0.3, 0, 0);"
            );
        } else {
            setStyle(
                    "-fx-font-family: 'Verdana';" +
                            "-fx-font-size: 25px;" +
                            "-fx-text-fill: linear-gradient(#fffdf0, #eff3ea);" +
                            "-fx-font-weight: bold;"
            );
        }
    }
}
