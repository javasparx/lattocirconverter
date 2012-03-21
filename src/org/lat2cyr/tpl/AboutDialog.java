package org.lat2cyr.tpl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AboutDialog extends Stage {
	
	//Image icon = new Image("/org/lat2cyr/resources/icons/logo.png");
	//ImageView imgView = new ImageView();
	Label lblTitle = new Label("Latin 2 Cyrilic Converter");
	Label lblVersion = new Label("Version: 1.0");
	Label lblAuthors  = new Label("Authors: Djordje Zeljic, Zoran Pavlovic");
	Label lblMail = new Label("e-Mail: zeljic@gmail.com, zoranp90@gmail.com");
	Button btnClose = new Button("Close");
	
	
		
	public AboutDialog(){
			
	}
	
	public void open(){
		
		Group root = new Group();
		
		//Adding BorderPane
		BorderPane border = new BorderPane();
		
		//Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(7));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		//Addding VBOX
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(10);
		
		//Adding shadow to object
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);		
		
		
		//Logo image
		Image image = new Image("src/org/lat2cyr/resources/icons/logo.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image);
        
        //Adding  ImageView to VBOX           
        vbox.getChildren().add(iv1);
        
           
		//GridPane components
		GridPane.setMargin(lblTitle, new Insets(0, 50, 0, 50));
		lblTitle.setFont(new Font("Arial", 20.0));
		lblTitle.setEffect(ds);
		gridPane.add(lblTitle, 1, 0);
		lblVersion.setEffect(ds);
		gridPane.add(lblVersion, 1, 1);
		lblAuthors.setEffect(ds);
		gridPane.add(lblAuthors, 1, 2);
		lblMail.setEffect(ds);
		gridPane.add(lblMail, 1,3);
		btnClose.setStyle("-fx-font: 12 arial; -fx-base: #b6e7c9;");
		btnClose.setPrefSize(80, 25);
		gridPane.add(btnClose, 1, 4);
		GridPane.setHalignment(btnClose, HPos.RIGHT);
		
		//Reflection and adding reflection to ROOT
		Reflection r = new Reflection();
	    r.setFraction(0.1);
	    root.setEffect(r);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			close();
			System.out.println("What?");
			}
		});
		
		//Add VBOX on left side of BorderPane
		border.setLeft(vbox); 
		
		//Add GridPane to center of BorderPane
		border.setCenter(gridPane);
		
		//Add VBOX, BorderPane and GridPane to ROOT 
		root.getChildren().add(gridPane);
        root.getChildren().add(vbox);
        root.getChildren().add(border);
      	
      	
		Scene scene = new Scene(root);
		this.setTitle("About");
		this.setScene(scene);
		//this.setResizable(false);
		this.show();
		
		
		
		
		
	}

}
