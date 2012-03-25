package org.lat2cyr.tpl.tabs;

import org.lat2cyr.tpl.toolbars.LatinToolbar;
import org.lat2cyr.utils.Converter;
import org.lat2cyr.utils.Converter.ConvertType;
import org.lat2cyr.utils.I18n;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Lat2CyrTab extends Tab {

	private LatinToolbar toolbar = new LatinToolbar();
	private VBox wrap = new VBox();
	private VBox pane = new VBox();
	private Label sourceLbl = new Label();
	private TextArea sourceTx = new TextArea();
	private Label convertLbl = new Label();
	private TextArea convertTx = new TextArea();
	private Clipboard clip = Clipboard.getSystemClipboard();
	private Converter converter = new Converter();

	public Lat2CyrTab() {

		initComponents();
		initActions();

	}

	private void initComponents() {
		this.setText(I18n.localize("Latin to Cyrillic"));
		this.setContent(wrap);

		VBox.setMargin(pane, new Insets(10));
		VBox.setVgrow(pane, Priority.ALWAYS);
		VBox.setVgrow(wrap, Priority.ALWAYS);
		wrap.getChildren().addAll(pane, toolbar);

		// source label
		sourceLbl.setText(I18n.localize("Latin"));
		pane.getChildren().add(sourceLbl);

		// source textarea
		sourceTx.setStyle("-fx-font: 13px \"Courier New\";");
		pane.getChildren().add(sourceTx);
		sourceTx.setWrapText(true);
		VBox.setVgrow(sourceTx, Priority.ALWAYS);

		//convert label
		convertLbl.setText(I18n.localize("Cyrillic"));
		pane.getChildren().add(convertLbl);
		VBox.setMargin(convertLbl, new Insets(10, 0, 0, 0));

		// convert textarea
		convertTx.setStyle("-fx-font: 13px \"Courier New\";");
		convertTx.setEditable(false);
		convertTx.setWrapText(true);
		pane.getChildren().add(convertTx);
		VBox.setVgrow(convertTx, Priority.ALWAYS);
	}

	private void initActions(){

		toolbar.pasteBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if(clip.hasString())
					sourceTx.setText(clip.getString());
				sourceTx.setScrollTop(Integer.MAX_VALUE);
			}
		});

		toolbar.copyLatinBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				ClipboardContent cc = new ClipboardContent();
				cc.putString(sourceTx.getText());
				if(cc.hasString())
					clip.setContent(cc);
			}
		});

		toolbar.copyCyrillicBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				ClipboardContent cc = new ClipboardContent();
				cc.putString(convertTx.getText());
				if(cc.hasString())
					clip.setContent(cc);
			}
		});

		toolbar.convertBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				convertTx.setText(converter.convertText(sourceTx.getText(), ConvertType.LAT2CYR));
				convertTx.setScrollTop(sourceTx.getScrollTop());
			}
		});

	}


}
