package org.lat2cyr.tpl;

import org.lat2cyr.tpl.MessageBox.MessageBoxType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author zeljic
 * @date Mar 11, 2012 - 1:26:48 AM
 */
public class MainPane extends VBox {

	private Label latLbl = new Label("Latin Text");
	private Label cyrLbl = new Label("Cirylic Text");
	private TextArea latTx = new TextArea();
	private TextArea cyrTx = new TextArea();
	private GridPane bottomPane = new GridPane();
	private VBox wrapBox = new VBox();
	private Button convertBtn = new Button("Convert");
	private ProgressBar progressBar = new ProgressBar();
	private String txStyle = "-fx-font: 12 monospace; " +
						"-fx-padding: 2;";
	private ChoiceBox<String> convertType = new ChoiceBox<String>();

	public MainPane() {
		initMenu();
		initCompoments();
	}

	private void initCompoments() {

		this.setStyle("-fx-background-color: #f1f1f1;");

		// wrap vbox
		wrapBox.setPadding(new Insets(5));

		// latLbl
		VBox.setMargin(latLbl, new Insets(0));
		wrapBox.getChildren().add(latLbl);



		// latTx
		wrapBox.getChildren().add(latTx);
		VBox.setMargin(latTx, new Insets(5, 0, 0, 0));
		VBox.setVgrow(latTx, Priority.ALWAYS);
		latTx.setStyle(txStyle);
		latTx.setWrapText(true);



		// cirLbl
		VBox.setMargin(cyrLbl, new Insets(10, 0, 0, 0));
		wrapBox.getChildren().add(cyrLbl);



		// cirTx
		wrapBox.getChildren().add(cyrTx);
		VBox.setMargin(cyrTx, new Insets(5, 0, 0, 0));
		VBox.setVgrow(cyrTx, Priority.ALWAYS);
		cyrTx.setStyle(txStyle);
		cyrTx.setWrapText(true);

		// progress bar
		progressBar.setProgress(0);
		progressBar.setPrefSize(300, 16);
		progressBar.setDisable(true);

		// convert type combobox
		convertType.getItems().addAll("Latin to Cyrilic", "Cyrilic to Latin");
		convertType.getSelectionModel().select(0);

		// bottom pane
		bottomPane.setPadding(new Insets(5));
		bottomPane.add(progressBar, 0, 0);
		bottomPane.add(convertType, 1, 0);
		bottomPane.add(convertBtn, 2, 0);


		GridPane.setHgrow(convertType, Priority.ALWAYS);
		GridPane.setHalignment(convertType, HPos.RIGHT);

		GridPane.setHgrow(convertBtn, Priority.SOMETIMES);
		GridPane.setHalignment(convertBtn, HPos.RIGHT);

		GridPane.setMargin(convertType, new Insets(0, 5, 0, 0));

		VBox.setVgrow(wrapBox, Priority.ALWAYS);
		VBox.setVgrow(bottomPane, Priority.SOMETIMES);
		this.getChildren().addAll(wrapBox, bottomPane);

		convertBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				MessageBox.show(MessageBoxType.ERROR, "Error", "This is my custom error message! And this message can be must more larger and bigger!All other strings need to be more flexible!");
			}
		});

	}

	private void initMenu() {
		//Menu
		MenuBar menuBar = new MenuBar();

		//File menu - import, export,print, exit
		Menu FileMenu = new Menu("File");
		FileMenu.getItems().add(new MenuItem("Import"));
		FileMenu.getItems().add(new MenuItem("Export"));
		FileMenu.getItems().add(new SeparatorMenuItem());
		FileMenu.getItems().add(new MenuItem("Print"));
		FileMenu.getItems().add(new SeparatorMenuItem());
		FileMenu.getItems().add(new MenuItem("Exit"));

		// Adding File menu to MenuBar
		menuBar.getMenus().add(FileMenu);


		//Edit menu - copy, paste, clear
		Menu EditMenu = new Menu("Edit");
		EditMenu.getItems().add(new MenuItem("Copy"));
		EditMenu.getItems().add(new MenuItem("Paste"));
		EditMenu.getItems().add(new MenuItem("Clear"));

		// Adding Edit menu to MenuBar
		menuBar.getMenus().add(EditMenu);


		//Edit menu - About
		Menu HelpMenu = new Menu("Help");
		HelpMenu.getItems().add(new MenuItem("About"));

		// Adding Edit menu to MenuBar
		menuBar.getMenus().add(HelpMenu);

		//Adding MenuBar to VBox
		this.getChildren().add(menuBar);
	}

}
