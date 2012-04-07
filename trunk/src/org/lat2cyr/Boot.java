package org.lat2cyr;

import org.lat2cyr.tpl.MainPane;
import org.lat2cyr.utils.I18n;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Djordje Zeljic
 */
public class Boot extends Application {

    private static Stage _instance = null;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage(){
    	return _instance;
    }

    private static void setStage(Stage stage){
    	_instance = stage;
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
        Boot._instance.setTitle(I18n.localize("Latin to Cyrillic Converter"));
        Boot._instance.setResizable(true);
    }

}
