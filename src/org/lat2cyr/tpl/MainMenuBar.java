package org.lat2cyr.tpl;

import org.lat2cyr.utils.I18n;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MainMenuBar extends MenuBar {

	private Menu fileMn = new Menu(I18n.localize("File"));

	public MainMenuBar() {

		this.getMenus().add(fileMn);

	}

}
