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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CreateMeeting {
	
  private static WebDriver driver = null;
  String conferenceRoom = "SM-Room15";
  String username = PropertiesReader.getUsername();
  String organizer = username;
  String subject = Generator.getRandomString();
  String attendee = PropertiesReader.getUsername() + "@" + PropertiesReader.getExchangeDomain();
  String password = PropertiesReader.getPassword();
  
  @Test
  public void createMeeting(){
	  LogManager.startTestCase("Make sure that is possible to create a Meeting after entering all Scheduler form required fields");
	  String errorMessage = "The meeting was not created"; 
	  driver.get(PropertiesReader.getRoomManagerTabletURL());
	  
	  SettingsPage settings = new SettingsPage(driver);
	  settings.selectConferenceRoom(conferenceRoom);
	  HomePage home = settings.clickAcceptButton();
	  SchedulerPage scheduler = home.clickScheduleButton();
	  scheduler.setOrganizerTextBox(organizer);
	  scheduler.setSubjectTextBox(subject);
	  scheduler.setAttendeesTextBox(attendee);
	  CredentialsPage credentials = scheduler.clickCreateButton();
	  credentials.setPasswordTextBox(password);
	  scheduler = credentials.clickOkButton();
	  
	  Assert.assertTrue(scheduler.exitsSubjectOnTimeline(subject) ,errorMessage);
	  LogManager.endTestCase();
  }
  @BeforeTest
  public void beforeTest() {
	  MeetingsAPI.removeAllMeetingsByRoomName(conferenceRoom, username, password);
  }

  @AfterTest
  public void afterTest() {
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
