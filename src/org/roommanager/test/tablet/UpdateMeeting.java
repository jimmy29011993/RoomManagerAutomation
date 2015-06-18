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
import org.roommanager.utils.api.MeetingsAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class UpdateMeeting {
	
  private static WebDriver driver = null;
  String conferenceRoom = "SM-Room5";
  String username = PropertiesReader.getUsername();
  String password = PropertiesReader.getPassword();
  String organizer = username;
  String subject = Generator.getRandomString();
  String startDate = Generator.getStartDate();
  String endDate = Generator.getEndDate(30);
  String newSubject = Generator.getRandomString();
  String attendee = PropertiesReader.getUsername() + "@" + PropertiesReader.getExchangeDomain();
  
  @Test
  public void updateSpecificMeeting() {
	  LogManager.startTestCase("Verify that is possible to update Meeting's data.");
	  String errorSubject = "The subject was not updated";
	  String errorAttendee = "The attendee was not updated"; 
	  driver.get(PropertiesReader.getRoomManagerTabletURL());
	  
	  SettingsPage settings = new SettingsPage(driver);
	  settings.selectConferenceRoom(conferenceRoom);
	  HomePage home = settings.clickAcceptButton();
	  SchedulerPage scheduler = home.clickScheduleButton();
	  scheduler.clickOnMeetingBox(subject);
	  scheduler.setSubjectTextBox(newSubject);
	  scheduler.setAttendeesTextBox(attendee);
	  CredentialsPage credentials = scheduler.clickUpdateButton();
	  credentials.setPasswordTextBox(password);
	  scheduler = credentials.clickOkButton();	  
	  
	  Assert.assertTrue(scheduler.exitsSubjectOnTimeline(newSubject), errorSubject);
	  Assert.assertTrue(scheduler.existAttendee(attendee), errorAttendee);
	  LogManager.endTestCase();
  }
  @BeforeTest
  public void beforeTest() {
	  MeetingsAPI.removeAllMeetingsByRoomName(conferenceRoom, username, password);
	  MeetingsAPI.createMeeting(conferenceRoom, username, password, organizer, subject, startDate, endDate);
  }

  @AfterTest
  public void afterTest() {
	  MeetingsAPI.removeAllMeetingsByRoomName(conferenceRoom, username, password);
  }

  @BeforeSuite
  public void beforeSuite() {
	  driver = SeleniumDriver.chromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  } 
}
