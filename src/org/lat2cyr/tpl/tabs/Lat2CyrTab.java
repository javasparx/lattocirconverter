package org.lat2cyr.tpl.tabs;

import java.io.File;
import org.lat2cyr.Boot;
import org.lat2cyr.tpl.MessageBox;
import org.lat2cyr.tpl.MessageBox.MessageBoxType;
import org.lat2cyr.tpl.toolbars.TabToolbar;
import org.lat2cyr.utils.Converter;
import org.lat2cyr.utils.DragAndDropManager;
import org.lat2cyr.utils.FileManager;
import org.lat2cyr.utils.Converter.ConvertType;
import org.lat2cyr.utils.I18n;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooserBuilder;
import javafx.util.Callback;

public class Lat2CyrTab extends Tab {

	private static TabToolbar toolbar = new TabToolbar();
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

	public static TabToolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(TabToolbar toolbar) {
		Lat2CyrTab.toolbar = toolbar;
	}

	private void initComponents() {
		this.setText(I18n.localize("Latin to Cyrillic"));
		this.setContent(wrap);

		VBox.setMargin(pane, new Insets(10));
		VBox.setVgrow(pane, Priority.ALWAYS);
		VBox.setVgrow(wrap, Priority.ALWAYS);
		wrap.getChildren().addAll(toolbar, pane);

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
			}
		});

		toolbar.copySourceBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				ClipboardContent cc = new ClipboardContent();
				cc.putString(sourceTx.getText());
				if(cc.hasString())
					clip.setContent(cc);
			}
		});

		toolbar.copyConvertBtn.onActionProperty().set(new EventHandler<ActionEvent>() {
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
			}
		});

		toolbar.importBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				FileChooser importChooser = FileChooserBuilder.create()
						.title(I18n.localize("Import textual file"))
						.build();

				importChooser.getExtensionFilters().add(new ExtensionFilter(I18n.localize("Textual file"), "*.txt"));

				File importFile = importChooser.showOpenDialog(Boot.getStage());

				if(importFile == null)
					return;

				try {
					sourceTx.setText(FileManager.getInstance().importFile(importFile));
				} catch (Exception e) {
					MessageBox.show(MessageBoxType.ERROR, "Import file", e.getMessage());
				}

			}
		});

		toolbar.exportBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {

				if(convertTx.getText().length() == 0)
					return;

				FileChooser exportChooser = FileChooserBuilder.create()
						.title(I18n.localize("Export converted text"))
						.extensionFilters(new ExtensionFilter("Textual File", "*.txt"))
						.build();

				File exportFile = exportChooser.showSaveDialog(Boot.getStage());

				if(!exportFile.getName().endsWith(".txt"))
					exportFile = new File(exportFile.getAbsolutePath().concat(".txt"));

				try{
					FileManager.getInstance().exportFile(exportFile, convertTx.getText());
				}catch (Exception e) {
					MessageBox.show(MessageBoxType.ERROR, "Export File", e.getMessage());
				}

			}
		});

		toolbar.clearBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				sourceTx.clear();
				convertTx.clear();
			}
		});

		sourceTx.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observe, String oldValue, String newValue) {
				if(newValue.length() > 0)
					sourceLbl.setText(I18n.localize("Latin").concat(" (" + newValue.length() + ")"));
				else
					sourceLbl.setText(I18n.localize("Latin"));
			}
		});

		convertTx.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observe, String oldValue, String newValue) {
				if(newValue.length() > 0)
					convertLbl.setText(I18n.localize("Cyrillic").concat(" (" + newValue.length() + ")"));
				else
					convertLbl.setText(I18n.localize("Cyrillic"));
			}
		});

		DragAndDropManager.getInstance().setImport(sourceTx, new Callback<String, String>() {
			@Override
			public String call(String text) {
				sourceTx.setText(text);
				return text;
			}
		});
	}
}
