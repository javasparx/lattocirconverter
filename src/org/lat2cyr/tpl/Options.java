package org.lat2cyr.tpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.lat2cyr.tpl.MessageBox.MessageBoxType;
import org.lat2cyr.tpl.tabs.Cyr2LatTab;
import org.lat2cyr.tpl.tabs.Lat2CyrTab;
import org.lat2cyr.utils.I18n;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Options extends Stage{

	private GridPane mainPane = new GridPane();

	private Label langLbl = new Label(I18n.localize("Language")+":");
	private ChoiceBox<String> langChb = new ChoiceBox<String>();
	private Button okBtn = new Button(I18n.localize("Save"));
	private File optionsFile = new File("options.ini");
	private Properties props = new Properties();

	public void open(){

		if(optionsFile.exists() && optionsFile.canRead()){
			try {
				props.load(new FileInputStream(optionsFile));
			} catch (Exception e) {
				MessageBox.show(MessageBoxType.ERROR, "Error", "Can't read options");
				return;
			}
		}else{
			makeDefaultOptionsFile();
		}

		initComponents();

	}

	private void initComponents(){

		mainPane.add(langLbl, 0, 0);
		mainPane.setHgap(5);
		mainPane.setVgap(5);


		GridPane.setHalignment(langChb, HPos.RIGHT);
		List<String> langList = getLangList();

		for(int i = 0; i < langList.size(); i++){
			langChb.getItems().add(langList.get(i));
			if(langList.get(i).equals(props.getProperty("clang")))
				langChb.getSelectionModel().select(i);
		}

		mainPane.add(langChb, 1, 0);

		// ok button
		GridPane.setHalignment(okBtn, HPos.RIGHT);
		mainPane.add(okBtn, 1, 1);
		GridPane.setMargin(okBtn, new Insets(20, 0, 0, 0));
		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				save();
			}
		});


		mainPane.setPrefWidth(300);
		mainPane.setPadding(new Insets(10));

		GridPane.setHgrow(okBtn, Priority.ALWAYS);
		mainPane.autosize();

		this.setTitle(I18n.localize("Options"));
		this.setScene(new Scene(mainPane));
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL);
		this.show();

	}

	private List<String> getLangList(){

		InputStream _in = getClass().getResourceAsStream("/org/lat2cyr/resources/languages/langs.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(_in));
		List<String> _r = new ArrayList<String>();
		String line = null;

		try{
			while((line = br.readLine()) != null)
			{
				String[] ar = line.split("=");
				_r.add(ar[1]);
			}
		}catch (Exception e) {}

		return _r;
	}
	public void doLayoutLanguage(){

		//Latin2Cyriilic Toolbar translation
		Lat2CyrTab.getToolbar().convertBtn.setText(I18n.localize("Convert"));
		Lat2CyrTab.getToolbar().importBtn.setText(I18n.localize("Import"));
		Lat2CyrTab.getToolbar().exportBtn.setText(I18n.localize("Export"));
		Lat2CyrTab.getToolbar().copyConvertBtn.setText(I18n.localize("Copy Latin"));
		Lat2CyrTab.getToolbar().copySourceBtn.setText(I18n.localize("Copy Cyrillic"));
		Lat2CyrTab.getToolbar().pasteBtn.setText(I18n.localize("Paste"));
		Lat2CyrTab.getToolbar().clearBtn.setText(I18n.localize("Clear All"));

		//Menu translation
		MainPane.getMainMb().fileMn.setText(I18n.localize("File"));
		MainPane.getMainMb().importMn.setText(I18n.localize("Import"));
		MainPane.getMainMb().exportMn.setText(I18n.localize("Export"));
		MainPane.getMainMb().exitMn.setText(I18n.localize("Exit"));
		MainPane.getMainMb().editMn.setText(I18n.localize("Edit"));
		MainPane.getMainMb().copyMn.setText(I18n.localize("Copy"));
		MainPane.getMainMb().copyLatin.setText(I18n.localize("Copy Latin"));
		MainPane.getMainMb().copyCyrilic.setText(I18n.localize("Copy Cyrillic"));
		MainPane.getMainMb().pasteMn.setText(I18n.localize("Paste"));
		MainPane.getMainMb().clearMn.setText(I18n.localize("Clear All"));
		MainPane.getMainMb().helpMn.setText(I18n.localize("Help"));
		MainPane.getMainMb().aboutMn.setText(I18n.localize("About"));
		MainPane.getMainMb().optionsMn.setText(I18n.localize("Options"));

		//Cyrilic2Latin Toolbar translation
		Cyr2LatTab.getToolbar().convertBtn.setText(I18n.localize("Convert"));
		Cyr2LatTab.getToolbar().importBtn.setText(I18n.localize("Import"));
		Cyr2LatTab.getToolbar().exportBtn.setText(I18n.localize("Export"));
		Cyr2LatTab.getToolbar().copyConvertBtn.setText(I18n.localize("Copy Latin"));
		Cyr2LatTab.getToolbar().copySourceBtn.setText(I18n.localize("Copy Cyrillic"));
		Cyr2LatTab.getToolbar().pasteBtn.setText(I18n.localize("Paste"));
		Cyr2LatTab.getToolbar().clearBtn.setText(I18n.localize("Clear All"));

		//Tabs name translation
		MainPane.getLat2CyrTab().setText(I18n.localize("Latin to Cyrillic"));
		MainPane.getCyr2LatTab().setText(I18n.localize("Cyrillic to Latin"));

		//Options dialog translation
		this.setTitle(I18n.localize("Options"));
		langLbl.setText(I18n.localize("Language"));
		okBtn.setText(I18n.localize("Save"));

		//About dialog translation
		AboutDialog ad = new AboutDialog();
		ad.setTitle(I18n.localize("About"));
		ad.btnClose.setText(I18n.localize("Close"));



		//MessageBox dialog translation

	}


	private void makeDefaultOptionsFile() {
		try {
			optionsFile.createNewFile();
			props.setProperty("clang", "English");
			props.store(new OutputStreamWriter(new FileOutputStream(optionsFile)), "Options file");
		} catch (Exception e) {
			MessageBox.show(MessageBoxType.ERROR, "Error", "Can't create options file");
		}
	}

	private boolean save(){
		if(langChb.getSelectionModel().getSelectedItem() == null)
			langChb.getSelectionModel().select("English");

		props.setProperty("clang", langChb.getSelectionModel().getSelectedItem());

		try {
			props.store(new OutputStreamWriter(new FileOutputStream(optionsFile)), "Options");
		} catch (Exception e) {
			MessageBox.show(MessageBoxType.ERROR, "Error", "Can't save options file");
		}

		I18n.langReselected = true;
		doLayoutLanguage();
		this.close();
		return true;
	}

}
