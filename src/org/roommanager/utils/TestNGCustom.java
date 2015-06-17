package org.roommanager.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TestNGCustom extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult result) {
		ScreenShot(result.getName());
	}
	
	private void ScreenShot(String testName) {
	try {
			String filePath;
			File directory = new File (".");		
			DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			Date date = new Date();		
			filePath = directory.getCanonicalPath()+ PropertiesReader.getScreenshotPath()+ testName + "-" + dateFormat.format(date) + ".png";
			Robot robot = new Robot();
			BufferedImage bi=robot.createScreenCapture(new Rectangle(1280,768));
			ImageIO.write(bi, "png", new File(filePath));
			System.setProperty("org.uncommons.reportng.escape-output", "false");  
			Reporter.log("<a href=\"" + filePath + "\"><p align=\"left\">Error: Screenshot at " + new Date()+ "</p>");
			Reporter.log("<img src=\"file://" + filePath + "\" alt=\"\" height='100' width='100' /><br/>");
		} 
		catch (AWTException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
