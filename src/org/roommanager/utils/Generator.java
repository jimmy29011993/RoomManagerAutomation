package org.roommanager.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;


public class Generator {
	private static String format = PropertiesReader.getFormatDate();
	private static int differenceOfHours = Integer.parseInt(PropertiesReader.getDifferenceOfHours());
	private static DateFormat dateFormat = new SimpleDateFormat(format);
	
	public static String getStartDate(){
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.HOUR, differenceOfHours);
		return dateFormat.format(calendar.getTime());
	}
	
	public static String getEndDate(int duration){
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.HOUR, differenceOfHours);
		calendar.add(Calendar.MINUTE,duration);
		return dateFormat.format(calendar.getTime());
	}
	
	public static String getRandomString(){
		return UUID.randomUUID().toString();
	}
}
