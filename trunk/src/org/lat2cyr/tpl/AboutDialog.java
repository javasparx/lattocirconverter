package org.lat2cyr.tpl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(7));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		Image image = new Image("info.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image);
		//GridPane.setConstraints(iv1, 0, 0);
		gridPane.add(iv1, 0, 0);
		GridPane.setMargin(lblTitle, new Insets(0, 50, 0, 50));
		gridPane.add(lblTitle, 0, 0);
		gridPane.add(lblVersion, 0, 1);
		gridPane.add(lblAuthors, 0, 2);
		gridPane.add(lblMail, 0, 3);
		gridPane.add(btnClose, 0, 4);
		GridPane.setHalignment(btnClose, HPos.RIGHT);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			close();
			}
		});
		
		Scene sc = new Scene(gridPane);
		this.setTitle("About");
		this.setScene(sc);
		this.setResizable(false);
		this.show();	
		
		
		
	}

}
