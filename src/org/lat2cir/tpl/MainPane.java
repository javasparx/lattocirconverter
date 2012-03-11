package org.lat2cir.tpl;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * @author zeljic
 * @date Mar 11, 2012 - 1:26:48 AM
 */
public class MainPane extends VBox {

	private Label latLbl = new Label("Latin Text");
	private Label cirLbl = new Label("Cirylic Text");
	private TextArea latTx = new TextArea();
	private TextArea cirTx = new TextArea();
	private Button convertBtn = new Button("Convert");

    public MainPane() {
    	initCompoments();
    }

	private void initCompoments() {
		this.setPadding(new Insets(10));

		this.getChildren().add(latLbl);
		this.getChildren().add(latTx);

		this.getChildren().add(cirLbl);
		this.getChildren().add(cirTx);

		this.getChildren().add(convertBtn);
	}

}
