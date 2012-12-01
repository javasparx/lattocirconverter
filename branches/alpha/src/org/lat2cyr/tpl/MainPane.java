package org.lat2cyr.tpl;

import org.lat2cyr.tpl.tabs.Cyr2LatTab;
import org.lat2cyr.tpl.tabs.Lat2CyrTab;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainPane extends VBox {
	
	private static MainMenuBar mainMb = new MainMenuBar();
	private TabPane tabPane = new TabPane();
	private static Tab lat2CyrTab = new Lat2CyrTab();
	private static Tab cyr2LatTab = new Cyr2LatTab();
	private static Label sourceLbl = new Label();
	private Label convertLbl = new Label();
	
	public MainPane() {

		// tabpan
		tabPane.setSide(Side.BOTTOM);
		tabPane.getTabs().addAll(lat2CyrTab, cyr2LatTab);
		tabPane.tabClosingPolicyProperty().set(TabClosingPolicy.UNAVAILABLE);


		// finally add all components to this component
		this.getChildren().addAll(mainMb, tabPane);
		VBox.setVgrow(tabPane, Priority.ALWAYS);
		
	}
	
	public static Tab getCyr2LatTab() {
		return cyr2LatTab;
	}

	public void setCyr2LatTab(Tab cyr2LatTab) {
		MainPane.cyr2LatTab = cyr2LatTab;
	}

	
	public static Tab getLat2CyrTab() {
		return lat2CyrTab;
	}

	public void setLat2CyrTab(Tab lat2CyrTab) {
		MainPane.lat2CyrTab = lat2CyrTab;
	}
	
	public static MainMenuBar getMainMb() {
		return mainMb;
	}

	public void setMainMb(MainMenuBar mainMb) {
		MainPane.mainMb = mainMb;
	
	}
	
	public Label getConvertLbl() {
		return convertLbl;
	}

	public void setConvertLbl(Label convertLbl) {
		this.convertLbl = convertLbl;
	}

	public static Label getSourceLbl() {
		return sourceLbl;
	}

	public static void setSourceLbl(Label sourceLbl) {
		MainPane.sourceLbl = sourceLbl;
	}

	

}
