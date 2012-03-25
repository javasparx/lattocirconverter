package org.lat2cyr.tpl.toolbars;

import org.lat2cyr.utils.I18n;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LatinToolbar extends ToolBar {

	public Button importBtn = null;
	public Button exportBtn = null;
	public Button pasteBtn = null;
	public Button copyLatinBtn = null;
	public Button copyCyrillicBtn = null;
	public Button convertBtn = null;

	public LatinToolbar() {

		initComponents();

		this.getItems().addAll(importBtn ,exportBtn, pasteBtn, copyLatinBtn, copyCyrillicBtn, convertBtn);
	}

	private void initComponents() {

		importBtn = ButtonBuilder.create()
				.text(I18n.localize("Import"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/import.png"))))
				.build();

		exportBtn = ButtonBuilder.create()
				.text(I18n.localize("Export"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/export.png"))))
				.build();

		pasteBtn = ButtonBuilder.create()
				.text(I18n.localize("Paste"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/paste.png"))))
				.build();

		copyLatinBtn = ButtonBuilder.create()
				.text(I18n.localize("Copy Latin"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/copy.png"))))
				.build();

		copyCyrillicBtn = ButtonBuilder.create()
				.text(I18n.localize("Copy Cyrillic"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/copy.png"))))
				.build();

		convertBtn = ButtonBuilder.create()
				.text(I18n.localize("Convert"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/convert.png"))))
				.build();

	}

}
