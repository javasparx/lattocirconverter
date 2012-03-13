package org.lat2cir.tpl;

import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MessageBox extends Stage {

	private static MessageBox _instance = null;
	public enum MessageBoxType {
		INFO, WARNING, ERROR
	}
	private static HashMap<MessageBoxType, String> iconsList = new HashMap<MessageBoxType, String>();

	private MessageBox(){}

	private static MessageBox _get_instance(){
		// set icons
		iconsList.put(MessageBoxType.INFO, "/org/lat2cir/resources/icons/info.png");
		iconsList.put(MessageBoxType.WARNING, "/org/lat2cir/resources/icons/warning.png");
		iconsList.put(MessageBoxType.ERROR, "/org/lat2cir/resources/icons/error.png");
		return _instance == null ? _instance = new MessageBox() : _instance;
	}

	public static void show(MessageBoxType type, String title, String message){
		_get_instance();

		// components
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(7));

		Label msgLbl = new Label(message);
		Image icon = new Image(MessageBox.class.getResourceAsStream(iconsList.get(type)));
		ImageView imgView = new ImageView(icon);
		GridPane.setConstraints(imgView, 0, 0);
		gridPane.add(imgView, 0, 0);
		gridPane.add(msgLbl, 1, 0);


		// init scene
		Scene sc = new Scene(gridPane);
		_instance.setScene(sc);

//		_instance.initModality(Modality.APPLICATION_MODAL);
		_instance.setResizable(false);
		_instance.setTitle(title);
		_instance.sizeToScene();

		// finally show dialog
		_instance.show();
	}

}
