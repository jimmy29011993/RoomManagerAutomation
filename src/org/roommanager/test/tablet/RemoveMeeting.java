package org.roommanager.test.tablet;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.tablet.home.HomePage;
import org.roommanager.pages.tablet.scheduler.CredentialsPage;
import org.roommanager.pages.tablet.scheduler.SchedulerPage;
import org.roommanager.pages.tablet.settings.SettingsPage;
import org.roommanager.utils.Generator;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.roommanager.utils.api.EmailServerAPI;
import org.roommanager.utils.api.MeetingsAPI;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RemoveMeeting {
	
  private static WebDriver driver = null;
  String conferenceRoom = "SM-Room20";
  String username = PropertiesReader.getUsername();
  String password = PropertiesReader.getPassword();
  String organizer = username;
  String subject = Generator.getRandomString();
  String startDate = Generator.getStartDate();
  String endDate = Generator.getEndDate(30);
  
  @Test
  public void removeSpecificMeeting() { 
	  LogManager.startTestCase("Verify that is possible to remove a Meeting of a Room after provide valid credentials");
	  String errorMessage = "The meeting was not removed"; 	  
	  driver.get(PropertiesReader.getRoomManagerTabletURL());
	  
	  SettingsPage settings = new SettingsPage(driver);
	  settings.selectConferenceRoom(conferenceRoom);
	  HomePage home = settings.clickAcceptButton();
	  SchedulerPage scheduler = home.clickScheduleButton();
	  scheduler.clickOnMeetingBox(subject);	  
	  CredentialsPage credentials = scheduler.clickRemoveButton();
	  credentials.setPasswordTextBox(password);	  
	  scheduler = credentials.clickOkButton();
	  
	  Assert.assertFalse(scheduler.exitsSubjectOnTimeline(subject),errorMessage);
	  LogManager.endTestCase();
  }
  @BeforeTest
  public void beforeTest() {
	  MeetingsAPI.removeAllMeetingsByRoomName(conferenceRoom, username, password);
	  MeetingsAPI.createMeeting(conferenceRoom, username, password, organizer, subject, startDate, endDate);
  }

  @AfterTest
  public void afterTest(){
	  MeetingsAPI.removeAllMeetingsByRoomName(conferenceRoom, username, password);
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  driver = SeleniumDriver.chromeDriver();
	  if(EmailServerAPI.getEmailServer() == null){
		  EmailServerAPI.registerEmailServer(username, password, PropertiesReader.getHostname());
	  }
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }
}
