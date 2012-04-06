package org.lat2cyr.tpl;

import org.lat2cyr.utils.I18n;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelpContents extends Stage {
	
	ListView<String> list = new ListView<String>();
	Label lblHeader = new Label("Help Contents");
	Label lblTitle = new Label("Contents:");
	Label lblDetails = new Label("Details:");
	Button btnClose = new Button(I18n.localize("Close"));
	TextArea txtContent = new TextArea();
	Image image = new Image("src/org/lat2cyr/resources/icons/help.png");
	ObservableList<String> data = FXCollections.observableArrayList(
            "Convert", "Import", "Export", "Drag and Drop", "Copy Latin", "Copy Cyrilic", "About", "Exit");
	String str = null;
	
	public HelpContents(){
		
	}
	
	public void open(){
		Group root = new Group();

		//Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(7));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		//Adding help image
		ImageView iv1 = new ImageView();
		iv1.setFitHeight(92);
		iv1.setFitWidth(92);
		iv1.setImage(image);
		GridPane.setMargin(iv1, new Insets(0, 25, 0, 25));
		gridPane.add(iv1, 0, 0);
		
		//Header title
		lblHeader.setFont(Font.font("Amble CN", FontWeight.BOLD, 36));
		gridPane.add(lblHeader, 1, 0);	
		
		//List title
		lblTitle.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
		GridPane.setMargin(lblTitle, new Insets(0, 0, 0, 0));
		gridPane.add(lblTitle, 0, 1);
		
		//Details title
		lblDetails.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
		gridPane.add(lblDetails,1,1);
		
		//Adding list with pref size
		list.setPrefSize(175, 200);
		gridPane.add(list, 0, 2);
		
		//Adding txtContent with wrap text and pref size
		txtContent.setWrapText(true);
		txtContent.setPrefSize(300, 200);
		gridPane.add(txtContent, 1, 2);
		
		//Adding button Close, with position and size
		gridPane.add(btnClose, 1, 3);
		GridPane.setHalignment(btnClose, HPos.RIGHT);
		btnClose.setPrefSize(80, 25);
		
		//Adding items from  data to list
		list.setItems(data);
		
		//Detecting mouse clicked
		list.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 @Override
	          public void handle(MouseEvent arg0) {
	        	  	  //Check wich list index is selected then set txtContent value for that index 
				 if(list.getSelectionModel().getSelectedIndex() == 0){
					 str = "Convert, here will go some text about converting from latin to cyrillic...";
					 txtContent.setText(str);					 
				 }
				 
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 1){
					 str = "Import, here will go some tutorial about importin .txt document to this program." +
					 		"User can import stuff through toolbar button Import, or through menu by clicing File menu, " +
					 		"then clicking on Import. Later you will get FileChooser to choose .txt file to open. It MUST be" +
					 		".txt file. Otherwise you will get error message box, to warn you that you didn't import .txt file.";
					 
					 txtContent.setText(str);
					 
				 }
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 2){
       			  str = "Here will go some short tutorial about exporting converted text to .txt document.";
       			  txtContent.setText(str);
       		  }
				 
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 3){
	        			  str = "bLatin2Cyrilic allows you to drag and drop .txt document. " +
	        			  		"Simply you choose some your .txt file and drag and drop it to text area.";
	        			  txtContent.setText(str);
	        		  }
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 4){
					 str = "Copy Latin, here will go some text about copy latin...";
					 txtContent.setText(str);					 
				 }
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 5){
					 str = "Copy Cyrillic, here will go some text about copy cyrillic...";
					 txtContent.setText(str);					 
				 }
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 6){
					 str = "About, here will go some text about this program and about authors...";
					 txtContent.setText(str);					 
				 }
				 
				 else if(list.getSelectionModel().getSelectedIndex() == 7){
					 str = "How to exit from this program...";
					 txtContent.setText(str);					 
				 }
				 
	        	  }
	          	 
	      });
		 
	//Action on btnClose	
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					close();
				}
			});
		
		//Add VBOX, BorderPane and GridPane to ROOT
		root.getChildren().add(gridPane);
		
		Scene scene = new Scene(root);
		
		this.setTitle(I18n.localize("Help contents"));
		this.setScene(scene);
		this.setResizable(false);
		this.show();
	}
	
	

}
