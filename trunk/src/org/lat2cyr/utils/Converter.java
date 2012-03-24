package org.lat2cyr.utils;

public class Converter {

	private String[] listLat = null;
	private String[] listCyr = null;
	private int numThreads = 0;
	private int maxThreads = 100;

	public Converter() {
		initList();
	}

	private void initList() {
		String lat = "A B C Č Ć D DŽ Đ E F G H I J K L LJ M N NJ O P R S Š T U V Z Ž";
		lat += " " + lat.toLowerCase();


		String cyr = "А Б Ц Ч Ћ Д Џ Ђ Е Ф Г Х И Ј К Л Љ М Н Њ О П Р С Ш Т У В З Ж";
		cyr += " " + cyr.toLowerCase();

		listLat = lat.split(" ");
		listCyr = cyr.split(" ");
	}

	public String convertLine(String line){

		int i = 0;
		for(String item : listLat)
		{
			line = line.replaceAll(item, listCyr[i]);
			i++;
		}

		return line;
	}

//	private synchronized void _checker(String converted){
//		numThreads--;
//	}
//
//	public String convertText(String text){
//
//		numThreads = text.split(" ").length;
//		int partSize = (Integer) text.length() / 1000;
//
//
//
//		for(int i = 0; i <= partSize; i++){
//
//			final String _line = text.substring(i * 1000, text.length() > (i + 1) * 1000 ? (i + 1) * 1000 : text.length() - (i + 1) * 1000);
//
//			Thread th = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					_checker(convertLine(_line));
//				}
//			});
//
//			th.start();
//
//		}
//
//		return "a";
//
//
//
//	}

}
