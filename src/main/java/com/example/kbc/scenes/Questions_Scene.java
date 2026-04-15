package com.example.kbc.scenes;

import com.example.kbc.Scene_Manager;
import com.example.kbc.components.Question;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Questions_Scene {
    private Scene_Manager manager;
    List<Question> questions = new ArrayList<>();
    int currentQuestionIndex = 0;

    Questions_Scene(Scene_Manager manager){
        this.manager = manager;
        initializeQuestions();
    }
    public void initializeQuestions(){
        questions.add(new Question(
                "What is 2 + 2?",
                new String[]{"3", "4", "5", "6"},
                1
        ));

        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Earth", "Jupiter", "Mars", "Venus"},
                2
        ));

        questions.add(new Question(
                "Who wrote 'Romeo and Juliet'?",
                new String[]{"Shakespeare", "Dickens", "Tolstoy", "Hemingway"},
                0
        ));

        questions.add(new Question(
                "What is the capital of Japan?",
                new String[]{"Seoul", "Beijing", "Tokyo", "Bangkok"},
                2
        ));

        questions.add(new Question(
                "Which data structure uses FIFO?",
                new String[]{"Stack", "Queue", "Tree", "Graph"},
                1
        ));

        questions.add(new Question(
                "Time complexity of binary search?",
                new String[]{"O(n)", "O(n log n)", "O(1)", "O(log n)"},
                3
        ));

        questions.add(new Question(
                "Which was batch was MIT Bengaluru's first batch?",
                new String[]{"batch of 2025", "batch of 2026", "batch of 2024", "batch of 2023"},
                0
        ));

        questions.add(new Question(
                "What does JVM stand for?",
                new String[]{"Java Variable Machine", "Java Virtual Machine", "Joint VM", "Java Verified Machine"},
                1
        ));

        questions.add(new Question(
                "Which Adil's Full Name?",
                new String[]{"Adil Zainul Syed", "Adil Mohammed Khan", "Adil Ali Zafar", "Adil Hamza Shaik"},
                0
        ));

        questions.add(new Question(
                "Which lab are we in right now?",
                new String[]{"AB4-403", "AB4-404", "AB4-405", "AB4-406"},
                2
        ));

        // FLIP QUESTION:
        questions.add(new Question(
                "Solve these 2 equations:\n \t 5x + 4y = 13\n \t 10x - 3y = 4",
                new String[]{"x = 1 and y = 2", "x = 2 and y = 2", "x = 1 and y = 1", "x = 2 and y = 1"},
                0
        ));
    }
    private void loadQuestion(Question q, Label questionLabel, Button[] optionButtons) {

        questionLabel.setText(q.getQuestionText());

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(q.getOptions()[i]);
        }
    }
    public Scene createScene(){
        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);

        Label questionLabel = new Label();
        questionLabel.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;"
        );

        HBox options = new HBox(20);
        options.setAlignment(Pos.CENTER);

        Button[] optionButtons = new Button[4];

        // initializing buttons
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new Button();
            optionButtons[i].setPrefWidth(200);

            optionButtons[i].setStyle(
                    "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 10;"
            );
        }

        // logic for correct, wrong and win
        for (int i = 0; i < 4; i++) {
            int index = i;
            optionButtons[i].setOnAction(e -> {
                Question current = questions.get(currentQuestionIndex);
                if (index == current.getCorrectAnswer()) {
                    System.out.println("Correct!");
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.size()) {
                        loadQuestion(questions.get(currentQuestionIndex), questionLabel, optionButtons);
                    } else {
                        System.out.println("YOU WON 7 CRORES!!!!!!!!!!");
                    }
                } else {
                    System.out.println("Wrong answer! Game Over");
                }
            });
        }
        loadQuestion(questions.get(currentQuestionIndex), questionLabel, optionButtons);
        for (Button b : optionButtons) {
            options.getChildren().add(b);
        }

        root.getChildren().addAll(questionLabel, options);

        String bgPath = getClass().getResource("/res/background.jpg").toExternalForm();
        root.setStyle(
                "-fx-background-image: url('" + bgPath + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );

        return new Scene(root, 1500, 700);
    }
}
