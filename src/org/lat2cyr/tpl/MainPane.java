package org.lat2cyr.tpl;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.lat2cyr.Boot;
import org.lat2cyr.I18N;
import org.lat2cyr.tpl.MessageBox.MessageBoxType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * @author zeljic
 * @date Mar 11, 2012 - 1:26:48 AM
 */
public class MainPane extends VBox {
	
	private Label latLbl = new Label("Latin Text");
	private Label cyrLbl = new Label("Cyrillic Text");
	private TextArea latTx = new TextArea();
	private TextArea cyrTx = new TextArea();
	private GridPane bottomPane = new GridPane();
	private VBox wrapBox = new VBox();
	private Button convertBtn = new Button(I18N.localize("Convert"));
	private ProgressBar progressBar = new ProgressBar();
	private String txStyle = "-fx-font: 12 monospace; " +
						"-fx-padding: 2;";
	private ChoiceBox<String> convertType = new ChoiceBox<String>();
	private FileChooser fileDialog = new FileChooser();

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
		convertType.getItems().addAll("Latin to Cyrillic", "Cyrillic to Latin");
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

			}
		});

	}

	private void initMenu() {
		//Menu
		MenuBar menuBar = new MenuBar();

		//File menu - import, export,print, exit
		Menu fileMn = new Menu("File");

		// file open menu
		Menu openMn = new Menu("Open");
		MenuItem fromLatin = new MenuItem("From Latin Source");
		fromLatin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				openFile(latTx);
			}
		});
		MenuItem fromCyrilic = new MenuItem("From Cyrillic Source");
		fromCyrilic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				openFile(cyrTx);
				cyrLbl.setText("Cyrillic Text (" + cyrTx.getText().length() + " chars)");
			}
		});

		openMn.getItems().addAll(fromLatin, fromCyrilic);

		// file save menu
		Menu saveMn = new Menu("Save As");
		MenuItem fromLatinSave = new MenuItem("From Latin Source");
		fromLatin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

			}
		});
		MenuItem fromCyrilicSave = new MenuItem("From Cyrillic Source");
		fromCyrilic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

			}
		});

		saveMn.getItems().addAll(fromLatinSave, fromCyrilicSave);

		MenuItem exitMn = new MenuItem("Exit");
		exitMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Boot.getStage().close();
			}
		});

		// add all menu items
		fileMn.getItems().addAll(openMn, saveMn, new SeparatorMenuItem(), exitMn);

		// Adding File menu to MenuBar
		menuBar.getMenus().add(fileMn);
		
		//Edit menu - About
		Menu HelpMenu = new Menu("Help");
		MenuItem about = new MenuItem("About");
		about.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				AboutDialog ad = new AboutDialog();
				ad.open();
			}
		});
		HelpMenu.getItems().add(about);

		// Adding Edit menu to MenuBar
		menuBar.getMenus().add(HelpMenu);

		//Adding MenuBar to VBox
		this.getChildren().add(menuBar);
	}

	private void openFile(Node tx){
		ExtensionFilter extFilter = new ExtensionFilter("All Text File", "*.txt");
		fileDialog.getExtensionFilters().add(extFilter);
		File _f = fileDialog.showOpenDialog( Boot.getStage().getScene().getWindow() );
		if(_f != null)
		{

			TextArea _tx = (TextArea) tx;
			_tx.clear();

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(_f), "utf-8"));

				String line = null;
				String _all = "";

				while((line = br.readLine()) != null)
		            _all += line;

				_tx.setText(_all);

		        br.close();

			} catch (Exception ex) {
				MessageBox.show(MessageBoxType.ERROR, "Error", "Error while reading selected file.");
				ex.printStackTrace();
			}
		}
	}

}
