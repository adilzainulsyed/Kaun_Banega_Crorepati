package com.example.kbc.scenes;

import com.example.kbc.Scene_Manager;
import com.example.kbc.components.Label_Styler;
import com.example.kbc.components.Question;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Questions_Scene {
    private Scene_Manager manager;
    List<Question> questions = new ArrayList<>();
    int currentQuestionIndex = 0;
    String[] prizemoney = {"1,000", "5,000", "10,000", "50,000", "1,00,000", "10,00,000","25,00,000", "50,00,000","1,00,00,000","7,00,00,000" };
    boolean used5050 = false;
    boolean usedPhone = false;
    boolean usedExpert = false;
    boolean usedFlip = false;

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
                "Which batch was MIT Bengaluru's first batch?",
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
                new String[]{"x = 2 and y = 2", "x = 1 and y = 2", "x = 1 and y = 1", "x = 2 and y = 1"},
                1
        ));
    }
    private void loadQuestion(Question q, Label questionLabel, Button[] optionButtons, Label que_no, Label prize) {
        questionLabel.setText(q.getQuestionText());
        que_no.setText("Question " + (currentQuestionIndex + 1));
        prize.setText("Prize: ₹" + prizemoney[currentQuestionIndex]);

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(q.getOptions()[i]);
        }
        for (Button b : optionButtons) {
            b.setDisable(false);
            b.setOpacity(1);
        }
    }
    private void resetButtonStyles(Button[] buttons) {
        for (Button b : buttons) {
            b.setStyle(
                    "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 10;"
            );
        }
    }
    public Scene createScene(){
        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);

        Label que_no = new Label();
        que_no.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-text-fill: gold;" +
                        "-fx-font-weight: bold;"
        );
        Label prize = new Label();
        prize.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-text-fill: gold;" +
                        "-fx-font-weight: bold;"
        );
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

        HBox topBar = new HBox(50);
        topBar.setAlignment(Pos.CENTER);
        topBar.getChildren().addAll(que_no, prize);

        Button phone_a_friend = new Button("Phone A Friend");
        phone_a_friend.setStyle(
                "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
        );
        phone_a_friend.setOnAction(e -> {
            if (usedPhone) return;

            usedPhone = true;
            phone_a_friend.setDisable(true);

            Question current = questions.get(currentQuestionIndex);

            int guess;
            if (Math.random() < 0.7) {
                guess = current.getCorrectAnswer(); // 70% correct
            } else {
                guess = (int)(Math.random() * 4);
            }

            Stage popup = new Stage();
            VBox box = new VBox(10);

            Label_Styler msg = new Label_Styler(
                    "Friend thinks answer is: " + current.getOptions()[guess],
                    "text"
            );

            box.getChildren().add(msg);
            box.setAlignment(Pos.CENTER);

            popup.setScene(new Scene(box, 300, 200));
            popup.show();
        });
        Button fifty_fifty = new Button("50/50");
        fifty_fifty.setStyle(
                "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
        );
        fifty_fifty.setOnAction(e -> {
            if (used5050) return;

            used5050 = true;
            fifty_fifty.setDisable(true);

            Question current = questions.get(currentQuestionIndex);
            int correct = current.getCorrectAnswer();

            int removed = 0;

            for (int i = 0; i < 4; i++) {
                if (i != correct && removed < 2) {
                    optionButtons[i].setDisable(true);
                    optionButtons[i].setOpacity(0.3);
                    removed++;
                }
            }
        });

        Button expert_advice = new Button("Expert Advice");
        expert_advice.setStyle(
                "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
        );
        expert_advice.setOnAction(e -> {
            if (usedExpert) return;

            usedExpert = true;
            expert_advice.setDisable(true);

        });
        Button flip_the_question = new Button("Flip the Question");
        flip_the_question.setStyle(
                "-fx-background-color: linear-gradient(#1e3c72, #2a5298);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
        );
        flip_the_question.setOnAction(e -> {
            if (usedFlip) return;

            usedFlip = true;
            flip_the_question.setDisable(true);

            Question newQ = questions.get(questions.size() - 1);


            loadQuestion(newQ, questionLabel, optionButtons, que_no, prize);
        });
        String lifelineStyle =
                "-fx-background-color: linear-gradient(#ffd700, #ffb300);" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 10 15;" +
                        "-fx-effect: dropshadow(gaussian, gold, 10, 0.5, 0, 0);";

        phone_a_friend.setStyle(lifelineStyle);
        fifty_fifty.setStyle(lifelineStyle);
        expert_advice.setStyle(lifelineStyle);
        flip_the_question.setStyle(lifelineStyle);

        HBox bottomBar = new HBox(30);
        bottomBar.setAlignment(Pos.CENTER);
        bottomBar.getChildren().addAll(phone_a_friend,fifty_fifty,expert_advice,flip_the_question);
        // logic for correct, wrong and win
        for (int i = 0; i < 4; i++) {
            int index = i;

            optionButtons[i].setOnAction(e -> {

                Question current = questions.get(currentQuestionIndex);

                // disabling the buttons during animation
                for (Button b : optionButtons) {
                    b.setDisable(true);
                }

                // colour is yellow so that there is uncertainity about answer being correct or wrong
                optionButtons[index].setStyle(
                        "-fx-background-color: yellow;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-weight: bold;"+"-fx-effect: dropshadow(gaussian, yellow, 20, 0.7, 0, 0);"
                );

                // Pausing for suspense
                PauseTransition pause1 = new PauseTransition(Duration.seconds(0.75));

                pause1.setOnFinished(
                        ev-> {
                            if (index == current.getCorrectAnswer()) {

                                // correct -> green
                                optionButtons[index].setStyle(
                                        "-fx-background-color: green;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-weight: bold;"+"-fx-effect: dropshadow(gaussian, lime, 20, 0.7, 0, 0);"
                                );

                            } else {

                                // wrong -> red
                                optionButtons[index].setStyle(
                                        "-fx-background-color: red;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-weight: bold;"+"-fx-effect: dropshadow(gaussian, red, 20, 0.7, 0, 0);"
                                );

                                // ALSO show correct answer in green (even if wrong)
                                optionButtons[current.getCorrectAnswer()].setStyle(
                                        "-fx-background-color: green;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-weight: bold;"+"-fx-effect: dropshadow(gaussian, lime, 20, 0.7, 0, 0);"
                                );
                            }
                        }
                );
                pause1.play();

                // Pausing to show if answer is correct or not
                PauseTransition pause2 = new PauseTransition(Duration.seconds(1.25));

                pause2.setOnFinished(ev -> {

                    if (index == current.getCorrectAnswer()) {

                        currentQuestionIndex++;

                        if (currentQuestionIndex < 10) {

                            // Reset button styles
                            resetButtonStyles(optionButtons);

                            // enabling the button again
                            for (Button b : optionButtons) {
                                b.setDisable(false);
                            }

                            loadQuestion(questions.get(currentQuestionIndex), questionLabel, optionButtons, que_no, prize);
                        } else {
                            Image logo = new Image(getClass().getResource("/res/logo.png").toExternalForm());
                            System.out.println("YOU WON 7 CRORES!!!!!!!!!!");
                            Stage gamewin = new Stage();
                            gamewin.getIcons().add(logo);
                            gamewin.setTitle("Thank you for playing!");
                            VBox gamewinlayout = new VBox(10);
                            Label_Styler gamewintext = new Label_Styler("YOU WON 7 CRORES!!!!!!!!!!","title");
                            gamewinlayout.getChildren().addAll(gamewintext);
                            gamewinlayout.setAlignment(Pos.CENTER);
                            Scene gameoverscene = new Scene(gamewinlayout,660,441);
                            String bgPath = getClass().getResource("/res/happy_amithab.gif").toExternalForm();
                            gamewinlayout.setStyle(
                                    "-fx-background-image: url('" + bgPath + "');" +
                                            "-fx-background-size: cover;" +
                                            "-fx-background-position: center;"
                            );
                            gamewin.setScene(gameoverscene);
                            gamewin.show();

                            manager.getStage().close();
                        }

                    } else {
                        Image logo = new Image(getClass().getResource("/res/logo.png").toExternalForm());
                        System.out.println("Wrong answer! Game Over");
                        Stage gameover = new Stage();
                        gameover.getIcons().add(logo);
                        gameover.setTitle("Thank you for playing!");
                        VBox gameoverlayout = new VBox(10);
                        Label_Styler gameovertext1 = new Label_Styler("Wrong Answer, Game Over!","text");
                        Label_Styler gameovertext2 = new Label_Styler("You won "+"₹"+((currentQuestionIndex > 0) ?prizemoney[currentQuestionIndex-1] : 0),"text");
                        gameoverlayout.getChildren().addAll(gameovertext1,gameovertext2);
                        gameoverlayout.setAlignment(Pos.CENTER);
                        Scene gameoverscene = new Scene(gameoverlayout,660,441);
                        String bgPath = getClass().getResource("/res/sad_amithab.gif").toExternalForm();
                        gameoverlayout.setStyle(
                                "-fx-background-image: url('" + bgPath + "');" +
                                        "-fx-background-size: cover;" +
                                        "-fx-background-position: center;"
                        );
                        gameover.setScene(gameoverscene);
                        gameover.show();
                        manager.getStage().close();
                    }
                });

                pause2.play();
            });
        }
        loadQuestion(questions.get(currentQuestionIndex), questionLabel, optionButtons, que_no, prize);        for (Button b : optionButtons) {
            options.getChildren().add(b);
        }

        root.getChildren().addAll(topBar,questionLabel, options, bottomBar);

        String bgPath = getClass().getResource("/res/background.jpg").toExternalForm();
        root.setStyle(
                "-fx-background-image: url('" + bgPath + "');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-position: center;"
        );

        return new Scene(root, 1500, 700);
    }
}
