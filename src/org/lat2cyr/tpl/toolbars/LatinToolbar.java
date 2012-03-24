package org.lat2cyr.tpl.toolbars;

import org.lat2cyr.utils.I18n;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LatinToolbar extends ToolBar {

	private Button importBtn = new Button(I18n.localize("Import"));
	private Button exportBtn = new Button(I18n.localize("Export"));
	private Button convertBtn = new Button("Convert");

	public LatinToolbar() {

		initComponents();

		this.getItems().addAll(importBtn ,exportBtn, convertBtn);
	}

	private void initComponents() {

		// import button
		importBtn.setText(I18n.localize("Import"));
//		importBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/import.png"))));

		// export button
		exportBtn.setText(I18n.localize("Export"));
//		exportBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/export.png"))));

		// convert button
		convertBtn.setText(I18n.localize("Convert"));
//		convertBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/convert.png"))));

	}

}
