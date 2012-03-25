package org.lat2cyr.tpl;

import org.lat2cyr.utils.I18n;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MainMenuBar extends MenuBar {

	//File menu
	private Menu fileMn = new Menu(I18n.localize("File"));
	private Menu openMn = new Menu(I18n.localize("Open"));
	private MenuItem fromLatin = new MenuItem(I18n.localize("From Latin Source"));
	private MenuItem fromCyrilic = new MenuItem(I18n.localize("From Cyrillic Source"));
	private Menu saveMn = new Menu(I18n.localize("Save"));
	private MenuItem latinSave = new MenuItem(I18n.localize("as Latin"));
	private MenuItem cyrilicSave = new MenuItem(I18n.localize("as Cyrillic"));
	private MenuItem exitMn = new MenuItem(I18n.localize("Exit"));
	
	//Edit menu
	private Menu editMn = new Menu(I18n.localize("Edit"));
	private Menu copyMn = new Menu(I18n.localize("Copy"));
	private MenuItem copyLatin = new MenuItem(I18n.localize("Latin text"));
	private MenuItem copyCyrilic = new MenuItem(I18n.localize("Cyrillic text"));
	private Menu pasteMn = new Menu(I18n.localize("Paste"));
	private MenuItem pasteLatin = new MenuItem(I18n.localize("Latin text"));
	private MenuItem pasteCyrilic = new MenuItem(I18n.localize("Cyrillic text"));
	private Menu clearMn = new Menu(I18n.localize("Clear"));
	private MenuItem clearLatin = new MenuItem(I18n.localize("Latin text"));
	private MenuItem clearCyrilic = new MenuItem(I18n.localize("Cyrillic text"));
	
	//Help menu
	private Menu helpMn = new Menu(I18n.localize("Help"));
	private MenuItem optionsMn = new MenuItem(I18n.localize("Options"));
	private MenuItem aboutMn = new MenuItem(I18n.localize("About"));
	
	

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
