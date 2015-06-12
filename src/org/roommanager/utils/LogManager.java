package org.roommanager.utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
 public class LogManager {

	 private static Logger Log = Logger.getLogger(LogManager.class.getName());
	 //PropertyConfigurator.configure();
 
 
 public static void startTestCase(String sTestCaseName){
	PropertyConfigurator.configure("resources/log4j.properties");
	Log.info("******************    "+sTestCaseName+ "     ******************");
	}

 
 public static void endTestCase(String sTestCaseName){
	 PropertyConfigurator.configure("resources/log4j.properties");
	Log.info("******************   "+"-E---N---D-"+"       ******************");
	}
 
 public static void info(String message) {
	 PropertyConfigurator.configure("resources/log4j.properties");
		Log.info(message);
 
		}
 
 public static void warn(String message) {
	 PropertyConfigurator.configure("resources/log4j.properties");
    Log.warn(message);
 
	}
 
 public static void error(String message) {
	 PropertyConfigurator.configure("resources/log4j.properties");
    Log.error(message);
 
	}
 
 public static void fatal(String message) {
	 PropertyConfigurator.configure("resources/log4j.properties");
    Log.fatal(message);
 
	}
 
 public static void debug(String message) {
	 PropertyConfigurator.configure("resources/log4j.properties");
    Log.debug(message);
 
	}
 
}