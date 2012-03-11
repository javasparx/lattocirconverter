package org.lat2cir;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Djordje Zeljic
 */
public class Boot extends Application {
    
    private Stage primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // init primaryScene
        this.primaryStage = primaryStage;
        initPrimaryScene();
        
        
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void initPrimaryScene() {
        this.primaryStage.setTitle("Lat2Cir Converter");
    }
    
}
