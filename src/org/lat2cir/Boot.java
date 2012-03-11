package org.lat2cir;

import org.lat2cir.tpl.MainPane;

import javafx.application.Application;
import javafx.scene.Scene;
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



        primaryStage.setScene(new Scene(new MainPane(), 600, 400));
        primaryStage.show();
    }

    private void initPrimaryScene() {
        this.primaryStage.setTitle("Lat2Cir Converter");
        this.primaryStage.setResizable(true);
    }

}
