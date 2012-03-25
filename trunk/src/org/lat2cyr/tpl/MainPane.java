package org.lat2cyr.tpl;

import org.lat2cyr.tpl.tabs.Cyr2LatTab;
import org.lat2cyr.tpl.tabs.Lat2CyrTab;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainPane extends VBox {

	private MainMenuBar mainMb = new MainMenuBar();
	private TabPane tabPane = new TabPane();
	private Tab lat2CyrTab = new Lat2CyrTab();
	private Tab cyr2LatTab = new Cyr2LatTab();


	public MainPane() {

		// tabpan
		tabPane.setSide(Side.BOTTOM);
		tabPane.getTabs().addAll(lat2CyrTab, cyr2LatTab);
		tabPane.tabClosingPolicyProperty().set(TabClosingPolicy.UNAVAILABLE);


		// finally add all components to this component
		this.getChildren().addAll(mainMb, tabPane);
		VBox.setVgrow(tabPane, Priority.ALWAYS);

	}

}
