package org.lat2cyr;

import org.lat2cyr.tpl.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Djordje Zeljic
 */
public class Boot extends Application {

    private static Stage primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage(){
    	return primaryStage;
    }

    private static void setStage(Stage stage){
    	primaryStage = stage;
    }

    @Override
    public void start(Stage primaryStage) {
        // init primaryScene
        setStage(primaryStage);
        initPrimaryScene();

        Scene scene = new Scene(new MainPane(), 650, 420);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initPrimaryScene() {
        Boot.primaryStage.setTitle("Lat2Cyr Converter");
        Boot.primaryStage.setResizable(true);
    }

}
