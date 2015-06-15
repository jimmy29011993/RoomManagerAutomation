package org.roommanager.utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogManager {

	private static Logger Log = Logger.getLogger(LogManager.class.getName());
 
	public static void startTestCase(String sTestCaseName){
		Log.info("******************    "+sTestCaseName+ "     ******************");
	}

 
	public static void endTestCase(){
		Log.info("**********************   "+"E N D"+"       ********************");
	}
 
	public static void info(String message) {
		Log.info(message);
	}
 
	public static void warn(String message) {
		Log.warn(message);
	}
 
	public static void error(String message) {
		Log.error(message);
	}
 
	public static void fatal(String message) {
		Log.fatal(message);
	}
 
	public static void debug(String message) {
		Log.debug(message);
	}
}