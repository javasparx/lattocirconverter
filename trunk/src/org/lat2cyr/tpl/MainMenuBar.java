package org.lat2cyr.tpl;

import org.lat2cyr.tpl.tabs.Lat2CyrTab;
import org.lat2cyr.utils.I18n;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MainMenuBar extends MenuBar {

	// File menu
	public Menu fileMn = new Menu(I18n.localize("File"));
	public MenuItem importMn = new MenuItem(I18n.localize("Import"));
	public MenuItem exportMn = new MenuItem(I18n.localize("Export"));
	public MenuItem convertMn = new MenuItem(I18n.localize("Convert"));
	public MenuItem exitMn = new MenuItem(I18n.localize("Exit"));

	// Edit menu
	public Menu editMn = new Menu(I18n.localize("Edit"));
	public Menu copyMn = new Menu(I18n.localize("Copy"));
	public MenuItem copyLatin = new MenuItem(I18n.localize("Copy Latin"));
	public MenuItem copyCyrilic = new MenuItem(I18n.localize("Copy Cyrillic"));
	public MenuItem pasteMn = new MenuItem(I18n.localize("Paste"));
	public MenuItem clearMn = new MenuItem(I18n.localize("Clear All"));

	// Help menu
	public Menu helpMn = new Menu(I18n.localize("Help"));
	public MenuItem optionsMn = new MenuItem(I18n.localize("Options"));
	public MenuItem aboutMn = new MenuItem(I18n.localize("About"));

	public MainMenuBar() {

		// Adding components to File menu

		fileMn.getItems().addAll(importMn, exportMn, new SeparatorMenuItem(),
				convertMn, new SeparatorMenuItem(), exitMn);

		// Adding components to Edit menu
		copyMn.getItems().addAll(copyLatin, copyCyrilic);
		editMn.getItems().addAll(copyMn, pasteMn, clearMn);

		// Adding components to Help menu
		helpMn.getItems().addAll(optionsMn, new SeparatorMenuItem(), aboutMn);

		// Adding File, Edit, Help menu to MenuBar
		this.getMenus().add(fileMn);
		this.getMenus().add(editMn);
		this.getMenus().add(helpMn);

		menuActions();

	}

	public void menuActions() {

		// File menu actions

		importMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Lat2CyrTab.getToolbar().importBtn.fireEvent(new ActionEvent());
			}
		});

		exportMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Lat2CyrTab.getToolbar().exportBtn.fireEvent(new ActionEvent());
			}
		});

		convertMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Lat2CyrTab.getToolbar().convertBtn.fireEvent(new ActionEvent());
			}
		});

		exitMn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				System.exit(0);
			}
		});

		// Edit menu actions
		copyLatin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Lat2CyrTab.getToolbar().copySourceBtn.fireEvent(new ActionEvent());
			}
		});
		
		copyCyrilic.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Lat2CyrTab.getToolbar().copyConvertBtn.fireEvent(new ActionEvent());
			}
		});
		
		pasteMn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Lat2CyrTab.getToolbar().pasteBtn.fireEvent(new ActionEvent());
			}
		});
		

		clearMn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Lat2CyrTab.getToolbar().clearBtn.fireEvent(new ActionEvent());
			}
		});

		// Help menu actions
		optionsMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new Options().open();
			}
		});

		aboutMn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AboutDialog ad = new AboutDialog();
				ad.open();
				
			}
		});

	}

}
