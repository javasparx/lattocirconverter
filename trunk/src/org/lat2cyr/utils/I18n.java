package org.lat2cyr.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

public class I18n {

	private static HashMap<String, String> pairs = null;
	private static Properties _props = null;
	public static boolean langReselected = true;

	public static String localize(String key){

		if(pairs == null || langReselected)
			generatePairs();

		String value = pairs.get(key);

		return value == null ? key : value;
	}

	private static void generatePairs(){

		pairs = new HashMap<String, String>();

		InputStream _in = I18n.class.getResourceAsStream("/org/lat2cyr/resources/languages/" + getCurrentLang() + ".ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(_in));

		String line = null;

		try{
			while((line = br.readLine()) != null)
			{
				String[] ar = line.split("=");
				pairs.put(ar[0], ar[1]);
			}
		}catch (Exception e) {}

		langReselected = false;

	}

	private static String getCurrentLang(){
		_props = new Properties();

		try {
			_props.load(new FileInputStream(new File("options.ini")));
			String current = _props.getProperty("clang");

			InputStream _in = I18n.class.getResourceAsStream("/org/lat2cyr/resources/languages/langs.ini");
			BufferedReader br = new BufferedReader(new InputStreamReader(_in));

			String line = null;

			while((line = br.readLine()) != null)
			{
				String[] ar = line.split("=");
				if(ar[1].equals(current))
					return ar[0];
			}

			return "en";
		} catch (Exception e) {
			return "en";
		}
	}

}
