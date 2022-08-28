package src.screens;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class titleScreen {
    public static void create(Stage primaryStage) {
        Pane root = new Pane();

        Image imgBackground = new Image("./././images/eskimodash-background.png");
        ImageView ivBackground = new ImageView(imgBackground);
        root.getChildren().add(ivBackground);

        Scene sceneTitle = new Scene(root, 
                                     imgBackground.getWidth(),
                                     imgBackground.getHeight());
        
        primaryStage.setScene(sceneTitle);
        primaryStage.show();
    }
}
