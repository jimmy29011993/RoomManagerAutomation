package org.roommanager.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesReader {
	
	private static Properties properties = new Properties();
	private static InputStream input = null;
	
	private static Properties getProperties(){
		try {
			input = new FileInputStream("resources/config.properties");
			properties.load(input);	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	public static String getRoomManagerAdminURL(){
		return getProperties().getProperty("ROOM_MANAGER_ADMIN_URL");
	}
	public static String getRoomManagerTabletURL(){
		return getProperties().getProperty("ROOM_MANAGER_TABLET_URL");
	}
	public static String getUsername(){
		return getProperties().getProperty("EXCHANGE_USERNAME");
	}
	public static String getHostname(){
		return getProperties().getProperty("EXCHANGE_HOSTNAME");
	}
	public static String getPassword(){
		return getProperties().getProperty("EXCHANGE_PASSWORD");
	}
	public static String getChromeDriverPath(){
		return getProperties().getProperty("CHROME_DRIVER_PATH");
	}
	public static String getRoomManagerBaseURL(){
		return getProperties().getProperty("ROOM_MANAGER_BASE_URL");
	}
	public static String getScreenshotPath(){
		return getProperties().getProperty("SCREENSHOT_PATH");
	}
	public static String getExchangeDomain(){
		return getProperties().getProperty("EXCHANGE_DOMAIN");
	}
  }
