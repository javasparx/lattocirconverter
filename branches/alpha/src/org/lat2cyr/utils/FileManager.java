package org.lat2cyr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileManager {

	private static FileManager _instance = null;

	private FileManager() {}

	public static FileManager getInstance(){
		return _instance == null ? _instance = new FileManager() : _instance;
	}

	public String importFile(File importFile) throws Exception
	{
		String text = "";
		if(importFile.exists() && importFile.canRead()){

			FileInputStream fis = null;

			try {
				fis = new FileInputStream(importFile);

				byte[] buff = new byte[64 * 1024];
				int read = -1;

				while((read = fis.read(buff)) != -1)
					text += new String(buff, 0, read);

			} catch (Exception e) {
				throw new Exception(I18n.localize("Can't read file"));
			} finally{
				if(fis != null)
					try {
						fis.close();
					} catch (Exception e) {
						throw new Exception("Can't close file");
					}
			}
		}else
			throw new Exception("Can't read file");

		return text;
	}

	public void exportFile(File exportFile, String content) throws Exception
	{

		if(!exportFile.exists())
			try {
				exportFile.createNewFile();
			} catch (Exception e) {
				throw new Exception(I18n.localize("File not exists"));
			}

		if(exportFile.canWrite()){
			FileOutputStream fos = null;

			try{

				fos = new FileOutputStream(exportFile);
				fos.write(content.getBytes());
				fos.close();

			}catch(Exception e){
				throw new Exception("Can't write file");
			}finally{
				try {
					fos.close();
				} catch (Exception e) {
					throw new Exception("Can't close file");
				}
			}
		}else
			throw new Exception(I18n.localize("Can't write file"));
	}

}
