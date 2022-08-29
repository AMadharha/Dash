package src.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        btnCharacterOne.setLayoutX(100);
        btnCharacterOne.setLayoutY(200);
        root.getChildren().add(btnCharacterOne);

        primaryStage.setScene(sceneCharacter);
    }
}
