package org.lat2cyr.tpl.toolbars;

import org.lat2cyr.utils.I18n;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TabToolbar extends ToolBar {

	public Button importBtn = null;
	public Button exportBtn = null;
	public Button pasteBtn = null;
	public Button copySourceBtn = null;
	public Button copyConvertBtn = null;
	public Button clearBtn = null;
	public Button convertBtn = null;
	
    

	public TabToolbar() {

		initComponents();
		

		this.getItems().addAll(importBtn ,exportBtn, pasteBtn, copySourceBtn, copyConvertBtn, clearBtn, convertBtn);
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

		copySourceBtn = ButtonBuilder.create()
				.text(I18n.localize("Copy Latin"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/copy.png"))))
				.build();

		copyConvertBtn = ButtonBuilder.create()
				.text(I18n.localize("Copy Cyrillic"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/copy.png"))))
				.build();

		clearBtn = ButtonBuilder.create()
				.text(I18n.localize("Clear All"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/clear.png"))))
				.build();

		convertBtn = ButtonBuilder.create()
				.text(I18n.localize("Convert"))
				.graphic(new ImageView(new Image(getClass().getResourceAsStream("/org/lat2cyr/resources/icons/convert.png"))))
				.build();

	}

}
