package src.screens;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class endScreen {
    public static void createAndSet(Stage primaryStage, int score, TextField tfName) {
        System.out.println(tfName.getText() + "=" + score);
    }
}
