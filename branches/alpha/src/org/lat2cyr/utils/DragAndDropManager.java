package org.lat2cyr.utils;

import org.lat2cyr.tpl.MessageBox;
import org.lat2cyr.tpl.MessageBox.MessageBoxType;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.util.Callback;

public class DragAndDropManager {

	private static DragAndDropManager _instance = null;

	private DragAndDropManager(){}

	public static DragAndDropManager getInstance()
	{
		return _instance == null ? _instance = new DragAndDropManager() : _instance;
	}

	public void setImport(Control cmp, final Callback<String, String> cb)
	{
		cmp.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				event.acceptTransferModes(TransferMode.MOVE);
				event.consume();
			}
		});

		cmp.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {

				Dragboard db = event.getDragboard();

				if(db.hasFiles() && db.getFiles().size() > 1)
				{
					MessageBox.show(MessageBoxType.WARNING, I18n.localize("Import File"), I18n.localize("Accept only one file"));
					event.setDropCompleted(true);
					return;
				}

				if( db.hasFiles() && db.getFiles().get(0).getAbsolutePath().endsWith(".txt") )
					try {
						cb.call(FileManager.getInstance().importFile( db.getFiles().get(0) ));
					} catch (Exception e) {
						MessageBox.show(MessageBoxType.WARNING, I18n.localize("Import File"), e.getMessage());
					}

				else if( db.hasString() )
					cb.call(db.getString());

				else
					MessageBox.show(MessageBoxType.WARNING, I18n.localize("Import File"), "Format not supported");

				event.consume();
			}

		});

	}

}
