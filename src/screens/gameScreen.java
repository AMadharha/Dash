package src.screens;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.objects.Character;

public class gameScreen {
    public static void createAndSet(TextField tfName, int characterNum, Stage primaryStage) {
        Pane root = new Pane();

        Image imgGameBackground = new Image("./././images/gameBackground.png");
        ImageView ivGameBackground = new ImageView(imgGameBackground);
        root.getChildren().add(ivGameBackground);

        Scene gameScene = new Scene(root,
                                    imgGameBackground.getWidth(),
                                    imgGameBackground.getHeight());
        
        int score = 0;
        Label lblScore = new Label();
		lblScore.setText("SCORE: " + score);
		lblScore.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 40));
        lblScore.setTextFill(Color.WHITE);
		lblScore.setLayoutX(20);
		lblScore.setLayoutY(20);                            
        root.getChildren().add(lblScore);

        Character player = new Character(characterNum);
        player.setX(imgGameBackground.getWidth()/2 - player.getWidth()/2);
		player.setY(imgGameBackground.getHeight()/2 - player.getHeight()/2);

        gameScene.setOnKeyPressed(e -> {
			if(player.isDead == false) {
				if(e.getEventType() == KeyEvent.KEY_PRESSED) {
					if(e.getCode() == KeyCode.A) {
						player.setX(player.getX() - 100);
						if(player.getX() <= 300) {
							player.setX(320);
						}
					}
					if(e.getCode() == KeyCode.D) {
						player.setX(player.getX() + 100);
						if(player.getX() + player.getWidth() >= 600) {
							player.setX(520);
						}
					}
				}
				player.getNode();
			}
		});

        KeyFrame kf = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				// If the player is not dead call the move method
				if(player.isDead == false) {
					player.move();
				}
			}
		});


        Timeline t = new Timeline(kf);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();

        Random rnd = new Random();
		int index = 0;

        

        primaryStage.setScene(gameScene);
        primaryStage.centerOnScreen();
    }
}
