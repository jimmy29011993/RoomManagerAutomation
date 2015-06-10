package org.roommanager.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesReader {
	Properties prop = new Properties();
	InputStream input = null;
	public PropertiesReader(){
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
	 
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
	}
	public String getRoomManagerAdminURL(){
		return prop.getProperty("ROOM_MANAGER_ADMIN_URL");
	}
	public String getUsername(){
		return prop.getProperty("EXCHANGE_USERNAME");
	}
	public String getHostname(){
		return prop.getProperty("EXCHANGE_HOSTNAME");
	}
	public String getPassword(){
		return prop.getProperty("EXCHANGE_PASSWORD");
	}
	public String getChromeDriverPath(){
		return prop.getProperty("CHROME_DRIVER_PATH");
	}
  }
