package src.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class characterSelectScreen {
    public static void createAndSet(Stage primaryStage) {
        Pane root = new Pane();

        Image imgBackground = new Image("./././images/characterSelectBackground.png");
        ImageView ivBackground = new ImageView(imgBackground);
        root.getChildren().add(ivBackground);

        Scene sceneCharacter = new Scene(root, 
                                         imgBackground.getWidth(),
                                         imgBackground.getHeight());

        TextField tfName = new TextField();
        tfName.setMinWidth(300);
        tfName.setMinHeight(40);
        tfName.setLayoutX(imgBackground.getWidth()/2 - 150);
        tfName.setLayoutY(130);
        tfName.setStyle("-fx-border-color: black; -fx-border-width: 3 3 3 3;");
        tfName.setEffect(new DropShadow());
        tfName.setAlignment(Pos.CENTER);
        root.getChildren().add(tfName);

        Image imgCharacterOne = new Image("./././images/characterOne.png");
        ImageView ivCharacterOne = new ImageView(imgCharacterOne);

        Button btnCharacterOne = new Button();
        btnCharacterOne.setStyle("-fx-background-color: transparent;");
        btnCharacterOne.setGraphic(ivCharacterOne);
        btnCharacterOne.setOnMouseEntered(e -> btnCharacterOne.setStyle("-fx-background-color: rgb(154,255,252,0.6)"));
        btnCharacterOne.setOnMouseExited(e -> btnCharacterOne.setStyle("-fx-background-color: transparent"));
        btnCharacterOne.setLayoutX(50);
        btnCharacterOne.setLayoutY(200);
        btnCharacterOne.setOnAction(e -> {
            int characterNum = 1;
            if(isValidName(tfName, characterNum, primaryStage) == true) {
                gameScreen.createAndSet(tfName, characterNum, primaryStage);
            }
        });
        root.getChildren().add(btnCharacterOne);

        Image imgCharacterTwo = new Image("./././images/characterTwo.png");
        ImageView ivCharacterTwo = new ImageView(imgCharacterTwo);

        Button btnCharacterTwo = new Button();
        btnCharacterTwo.setStyle("-fx-background-color: transparent;");
        btnCharacterTwo.setGraphic(ivCharacterTwo);
        btnCharacterTwo.setOnMouseEntered(e -> btnCharacterTwo.setStyle("-fx-background-color: rgb(154,255,252,0.6)"));
        btnCharacterTwo.setOnMouseExited(e -> btnCharacterTwo.setStyle("-fx-background-color: transparent"));
        btnCharacterTwo.setLayoutX(450);
        btnCharacterTwo.setLayoutY(200);
        btnCharacterTwo.setOnAction(e -> {
            int characterNum = 2;
            if(isValidName(tfName, characterNum, primaryStage) == true) {
                gameScreen.createAndSet(tfName, characterNum, primaryStage);
            }   
        });
        root.getChildren().add(btnCharacterTwo);

        Image imgCharacterThree = new Image("./././images/characterThree.png");
        ImageView ivCharacterThree = new ImageView(imgCharacterThree);

        Button btnCharacterThree = new Button();
        btnCharacterThree.setStyle("-fx-background-color: transparent");
        btnCharacterThree.setGraphic(ivCharacterThree);
        btnCharacterThree.setOnMouseEntered(e -> btnCharacterThree.setStyle("-fx-background-color: rgb(154,255,252,0.6)"));
        btnCharacterThree.setOnMouseExited(e -> btnCharacterThree.setStyle("-fx-background-color: transparent"));
        btnCharacterThree.setLayoutX(850);
        btnCharacterThree.setLayoutY(200);
        btnCharacterThree.setOnAction(e -> {
            int characterNum = 3;
            if(isValidName(tfName, characterNum, primaryStage) == true) {
                gameScreen.createAndSet(tfName, characterNum, primaryStage);
            }
        });
        root.getChildren().add(btnCharacterThree);

        primaryStage.setScene(sceneCharacter);
    }

    private static boolean isValidName(TextField tfName, int characterNum, Stage primaryStage) {
        if(tfName.getText() == null || tfName.getText().trim().isEmpty() || tfName.getText().contains("=")) {
            Alert alrtNoName = new Alert(AlertType.ERROR);
	        alrtNoName.setContentText("Please enter a valid username before selecting a character!");
	        alrtNoName.setTitle("Exit");
	        alrtNoName.setHeaderText(null);
	        alrtNoName.getButtonTypes().clear();
			alrtNoName.getButtonTypes().add(ButtonType.OK);
            alrtNoName.showAndWait();
            return false; 
        }
        return true;
    }
}
