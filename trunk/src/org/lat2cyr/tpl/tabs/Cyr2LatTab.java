package org.lat2cyr.tpl.tabs;

import org.lat2cyr.tpl.toolbars.LatinToolbar;
import org.lat2cyr.utils.I18n;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Cyr2LatTab extends Tab {

	private LatinToolbar toolbar = new LatinToolbar();
	private VBox wrap = new VBox();
	private VBox pane = new VBox();
	private Label sourceLbl = new Label();
	private TextArea sourceTx = new TextArea();
	private Label convertLbl = new Label();
	private TextArea convertTx = new TextArea();

	public Cyr2LatTab() {

		initComponents();

	}

	private void initComponents() {
		this.setText(I18n.localize("Cyrillic to Latin"));
		this.setContent(wrap);

		VBox.setMargin(pane, new Insets(10));
		VBox.setVgrow(pane, Priority.ALWAYS);
		VBox.setVgrow(wrap, Priority.ALWAYS);
		wrap.getChildren().addAll(pane, toolbar);

		// source label
		sourceLbl.setText(I18n.localize("Cyrillic"));
		pane.getChildren().add(sourceLbl);

		// source textarea
		pane.getChildren().add(sourceTx);
		sourceTx.setWrapText(true);
		VBox.setVgrow(sourceTx, Priority.ALWAYS);

		//convert label
		convertLbl.setText(I18n.localize("Latin"));
		pane.getChildren().add(convertLbl);
		VBox.setMargin(convertLbl, new Insets(10, 0, 0, 0));

		// convert textarea
		convertTx.setEditable(false);
		pane.getChildren().add(convertTx);
		VBox.setVgrow(convertTx, Priority.ALWAYS);


	}


}
