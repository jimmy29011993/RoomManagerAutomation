package org.roommanager.utils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.*;
import org.testng.TestListenerAdapter;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
import java.net.*;

public class TestNGCustom extends TestListenerAdapter {
	private int Count = 0;
	
	@Override
	public void onTestFailure(ITestResult tr) {
		ScreenShot(tr.getName());
	}
	
	private void ScreenShot(String testName) {
	try {
	
		String NewFileNamePath;
		File directory = new File (".");		
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		Date date = new Date();		
		NewFileNamePath = directory.getCanonicalPath()+ PropertiesReader.getScreenshotPath()+ dateFormat.format(date)+"-"+testName+ ".png";
		Robot robot = new Robot();
		BufferedImage bi=robot.createScreenCapture(new Rectangle(1280,768));
		ImageIO.write(bi, "png", new File(NewFileNamePath));
		Count++;
		System.setProperty("org.uncommons.reportng.escape-output", "false");  

		Reporter.log("<a href=\"" + NewFileNamePath + "\"><p align=\"left\">Error screenshot at " + new Date()+ "</p>");
		Reporter.log("<img src=\"file://" + NewFileNamePath + "\" alt=\"\" height='100' width='100' /><br/>");
		
		} 
		catch (AWTException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
