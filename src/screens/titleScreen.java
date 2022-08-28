package src.screens;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class titleScreen {
    public static void create(Stage primaryStage) {
        Pane root = new Pane();

        Image imgBackground = new Image("./././images/titleScreenBackground.png");
        ImageView ivBackground = new ImageView(imgBackground);
        root.getChildren().add(ivBackground);

        Scene sceneTitle = new Scene(root, 
                                     imgBackground.getWidth(),
                                     imgBackground.getHeight());
        
        Button btnPlay = new Button();
        btnPlay.setPrefSize(300,80);
        btnPlay.setText("PLAY");
        btnPlay.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR,40));
		btnPlay.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
		btnPlay.setOnMouseEntered(e -> btnPlay.setStyle("-fx-background-color: lightblue"));
		btnPlay.setOnMouseExited(e -> btnPlay.setStyle("-fx-background-color: white"));
		//btnPlay.setOnAction(e -> primaryStage.setScene(enterName));

        Button btnControls = new Button();
		btnControls.setPrefSize(300,80);
		btnControls.setText("CONTROLS");
		btnControls.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR,40));
		btnControls.setStyle("-fx-background-color: lightblue");
		btnControls.setOnMouseEntered(e -> btnControls.setStyle("-fx-background-color: white"));		
		btnControls.setOnMouseExited(e -> btnControls.setStyle("-fx-background-color: lightblue"));
		btnControls.setOnAction(e -> {
			Alert outputControls = new Alert(AlertType.INFORMATION);
			outputControls.setHeaderText(null);
			outputControls.setContentText("A - MOVE LEFT\nD - MOVE RIGHT");
			outputControls.setTitle("Controls");
			outputControls.getButtonTypes().clear();
			outputControls.getButtonTypes().add(ButtonType.OK);
			outputControls.showAndWait();
		});


        HBox hButtons = new HBox();
		hButtons.setSpacing(40);
		hButtons.getChildren().addAll(btnPlay, btnControls);
		hButtons.setLayoutX(imgBackground.getWidth()/2 - 980/2);
		hButtons.setLayoutY(imgBackground.getHeight() - 110);

        root.getChildren().add(hButtons);

        primaryStage.setScene(sceneTitle);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				Alert confirm = new Alert(AlertType.CONFIRMATION);
				confirm.setContentText("Are you sure you want to exit?");
				confirm.setTitle("Exit");
				confirm.setHeaderText(null);
				confirm.getButtonTypes().clear();
				confirm.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

				Optional<ButtonType> result = confirm.showAndWait();

				if(result.get() == ButtonType.NO) {
					e.consume();
				}
			}
		});
		primaryStage.centerOnScreen();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Dash");
		primaryStage.show();
    }
}
