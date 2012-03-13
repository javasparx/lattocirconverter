package org.lat2cyr.tpl;

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox extends Stage {

	private static MessageBox _instance = null;
	private static Boolean isCreated = false;

	public enum MessageBoxType {
		INFO, WARNING, ERROR
	}

	private static HashMap<MessageBoxType, String> iconsList = new HashMap<MessageBoxType, String>();

	private MessageBox() {
	}

	private static MessageBox _get_instance() {
		// set icons
		iconsList.put(MessageBoxType.INFO, "/org/lat2cyr/resources/icons/info.png");
		iconsList.put(MessageBoxType.WARNING, "/org/lat2cyr/resources/icons/warning.png");
		iconsList.put(MessageBoxType.ERROR, "/org/lat2cyr/resources/icons/error.png");

		return _instance == null ? _instance = new MessageBox() : _instance;
	}

	public static void show(MessageBoxType type, String title, String message) {
		_get_instance();

		// components
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(7));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Button okBtn = new Button("Ok");
		Label msgLbl = new Label(message);
		Image icon = new Image(MessageBox.class.getResourceAsStream(iconsList.get(type)));

		ImageView imgView = new ImageView(icon);
		GridPane.setConstraints(imgView, 0, 0);
		gridPane.add(imgView, 0, 0);
		gridPane.add(msgLbl, 1, 0);
		msgLbl.setWrapText(true);
		gridPane.add(okBtn, 1, 1);
		GridPane.setMargin(okBtn, new Insets(10, 0, 0, 0));

		GridPane.setHalignment(okBtn, HPos.RIGHT);
		okBtn.setPrefWidth(75);

		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				_instance.close();
			}
		});

		// init scene
		Scene sc = new Scene(gridPane);
		_instance.setWidth(400);
		_instance.setScene(sc);

		if(!isCreated)
		{
			_instance.initModality(Modality.APPLICATION_MODAL);
			isCreated = true;
		}

		_instance.setResizable(false);
		_instance.setTitle(title);
		_instance.sizeToScene();

		// finally show dialog
		_instance.show();
	}

}
