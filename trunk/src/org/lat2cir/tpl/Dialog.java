package org.lat2cir.tpl;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Dialog extends GridPane {
	public enum DialogEnum {
		INFO, ERROR
	}
	static DialogEnum DialogEnum;
	public static void main(String[] args) {
	        
	    }
	String msg;	
	String title;
	private Label msgLbl = new Label();
	private Button okBtn = new Button("Ok");
	private Image imgError= new Image("windows-error.png");
	
	
	private Image imgInfo = new Image("windows-info.png");
	
	private ImageView imgV = new ImageView();
	
	public Dialog(DialogEnum DialogEnum, String b, String a ){
		this.DialogEnum = DialogEnum;
		this.title = a;
		this.msg = b;
	}
	
	 public void State(){
		
		switch(DialogEnum) {
		
		case INFO:
			
			//Info dialog box
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			
			Group root = new Group();
			Scene scene = new Scene(root, 250,125);
			stage.setScene(scene);
			stage.show();
	
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new Insets(20,0,20,50));
		
			//imgInfo
			imgV.setImage(imgInfo);
			GridPane.setMargin(imgV, new Insets(0, 0, 0, 0));
			GridPane.setHalignment(imgV, HPos.CENTER);
			gridpane.add(imgV, 0, 0);
			
			//msgLbl
			msgLbl.setText(msg);
			GridPane.setMargin(msgLbl, new Insets(0, 0, 0, 0));
			GridPane.setHalignment(msgLbl, HPos.RIGHT);
			gridpane.add(msgLbl, 0,1);
			
			//okBtn
			GridPane.setMargin(okBtn, new Insets(10, 0, 0, 0));
			GridPane.setHalignment(okBtn, HPos.CENTER);
			okBtn.setPrefSize(80, 20);
			gridpane.add(okBtn, 0,2);
			
			root.getChildren().add(gridpane);
		break;

		case ERROR:
			
			//Error dialog box
			Stage stage1 = new Stage();
			stage1.setTitle(title);
			stage1.setResizable(false);
			stage1.initModality(Modality.APPLICATION_MODAL);
			
			Group root1 = new Group();
			Scene scene1 = new Scene(root1, 250,100);
			stage1.setScene(scene1);
			stage1.show();
			
			GridPane gridpane1 = new GridPane();
			gridpane1.setPadding(new Insets(20,0,20,50));
			
			//imgError
			imgV.setImage(imgError);
			GridPane.setMargin(imgV, new Insets(0, 0, 0, 0));
			GridPane.setHalignment(imgV, HPos.LEFT);
			gridpane1.add(imgV, 0, 0);
			
			//msgLbl
			msgLbl.setText(msg);
			GridPane.setMargin(msgLbl, new Insets(0, 0, 0, 0));
			GridPane.setHalignment(msgLbl, HPos.RIGHT);
			gridpane1.add(msgLbl, 0,1);
			
			//okBtn
			GridPane.setMargin(okBtn, new Insets(10, 0, 0, 0));
			GridPane.setHalignment(okBtn, HPos.CENTER);
			gridpane1.add(okBtn, 0,2 );
			root1.getChildren().add(gridpane1);
		break;
		}		
	}

}
