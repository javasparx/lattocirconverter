package org.lat2cyr.tpl;

import org.lat2cyr.utils.I18n;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MainMenuBar extends MenuBar {

	//File menu
	public Menu fileMn = new Menu(I18n.localize("File"));
	public Menu openMn = new Menu(I18n.localize("Open"));
	public MenuItem fromLatin = new MenuItem(I18n.localize("From Latin Source"));
	public MenuItem fromCyrilic = new MenuItem(I18n.localize("From Cyrillic Source"));
	public Menu saveMn = new Menu(I18n.localize("Save"));
	public MenuItem latinSave = new MenuItem(I18n.localize("as Latin"));
	public MenuItem cyrilicSave = new MenuItem(I18n.localize("as Cyrillic"));
	public MenuItem exitMn = new MenuItem(I18n.localize("Exit"));

	//Edit menu
	public Menu editMn = new Menu(I18n.localize("Edit"));
	public Menu copyMn = new Menu(I18n.localize("Copy"));
	public MenuItem copyLatin = new MenuItem(I18n.localize("Latin text"));
	public MenuItem copyCyrilic = new MenuItem(I18n.localize("Cyrillic text"));
	public Menu pasteMn = new Menu(I18n.localize("Paste"));
	public MenuItem pasteLatin = new MenuItem(I18n.localize("Latin text"));
	public MenuItem pasteCyrilic = new MenuItem(I18n.localize("Cyrillic text"));
	public Menu clearMn = new Menu(I18n.localize("Clear"));
	public MenuItem clearLatin = new MenuItem(I18n.localize("Latin text"));
	public MenuItem clearCyrilic = new MenuItem(I18n.localize("Cyrillic text"));

	//Help menu
	public Menu helpMn = new Menu(I18n.localize("Help"));
	public MenuItem optionsMn = new MenuItem(I18n.localize("Options"));
	public MenuItem aboutMn = new MenuItem(I18n.localize("About"));



	public MainMenuBar() {

		//Adding components to File menu
		openMn.getItems().addAll(fromLatin, fromCyrilic);
		saveMn.getItems().addAll(latinSave, cyrilicSave);
		fileMn.getItems().addAll(openMn, saveMn, new SeparatorMenuItem(), exitMn);

		//Adding components to Edit menu
		copyMn.getItems().addAll(copyLatin, copyCyrilic);
		pasteMn.getItems().addAll(pasteLatin, pasteCyrilic);
		clearMn.getItems().addAll(clearLatin, clearCyrilic);
		editMn.getItems().addAll(copyMn, pasteMn,new SeparatorMenuItem(), clearMn);

		//Adding components to Help menu
		helpMn.getItems().addAll(optionsMn, new SeparatorMenuItem(), aboutMn);


		//Adding File, Edit, Help menu to MenuBar
		this.getMenus().add(fileMn);
		this.getMenus().add(editMn);
		this.getMenus().add(helpMn);

	}



}
