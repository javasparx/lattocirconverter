package org.lat2cir.tpl;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
	private Button convertBtn = new Button("Convert");
	private ProgressBar progressBar = new ProgressBar();
	private String txStyle = "-fx-font: 12 monospace; " +
			"-fx-padding: 2;";
	private ChoiceBox<String> convertType = new ChoiceBox<>();

    public MainPane() {
    	initCompoments();
    }

	private void initCompoments() {
		this.setPadding(new Insets(10));
		this.setStyle("-fx-background-color: #f1f1f1;");

		// latLbl
		VBox.setMargin(latLbl, new Insets(0));
		this.getChildren().add(latLbl);



		// latTx
		this.getChildren().add(latTx);
		VBox.setMargin(latTx, new Insets(5, 0, 0, 0));
		VBox.setVgrow(latTx, Priority.ALWAYS);
		latTx.setStyle(txStyle);
		latTx.setWrapText(true);



		// cirLbl
		VBox.setMargin(cyrLbl, new Insets(10, 0, 0, 0));
		this.getChildren().add(cyrLbl);



		// cirTx
		this.getChildren().add(cyrTx);
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
		VBox.setMargin(bottomPane, new Insets(5, 0, 0, 0));
		bottomPane.add(progressBar, 0, 0);
		bottomPane.add(convertType, 1, 0);
		bottomPane.add(convertBtn, 2, 0);

		GridPane.setHgrow(convertType, Priority.ALWAYS);
		GridPane.setHalignment(convertType, HPos.RIGHT);

		GridPane.setHgrow(convertBtn, Priority.SOMETIMES);
		GridPane.setHalignment(convertBtn, HPos.RIGHT);

		GridPane.setMargin(convertType, new Insets(0, 5, 0, 0));

		this.getChildren().add(bottomPane);

	}

}
