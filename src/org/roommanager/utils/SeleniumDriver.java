package org.roommanager.utils;

import java.io.File;
import java.util.Date;

import org.apache.bcel.classfile.Constant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumDriver {
	
	private static SeleniumDriver instance = new SeleniumDriver();
	private static WebDriver driver = null;
	
	private SeleniumDriver(){
		
	}
	
	public static WebDriver firefoxDriver(){
		if(driver == null){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static WebDriver chromeDriver(){
		if(driver == null){
			System.setProperty("webdriver.chrome.driver", PropertiesReader.getChromeDriverPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static SeleniumDriver getInstance(){
		return instance;
	}
	
	public static void takeScreenshot(String sTestCaseName) throws Exception{
		Date date= new Date();
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(PropertiesReader.getScreenshotPath() + date.getTime() + "-" +sTestCaseName +".jpg"));	
		} catch (Exception e){
			LogManager.error(e.getMessage());
			throw new Exception();
		}
	}
}
