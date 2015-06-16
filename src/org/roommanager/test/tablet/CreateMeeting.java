package org.roommanager.test.tablet;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.tablet.home.HomePage;
import org.roommanager.pages.tablet.scheduler.CredentialsPage;
import org.roommanager.pages.tablet.scheduler.SchedulerPage;
import org.roommanager.pages.tablet.settings.SettingsPage;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CreateMeeting {
	
  private static WebDriver driver = null;
  
  @Test
  public void createMeeting() {
	  LogManager.startTestCase("Verify that is possible to create a meeting in a specific conference room"); 
	  String conferenceRoom = "RoomgGC-01";
	  String organizer = PropertiesReader.getUsername();
	  String subject = "Test";
	  String attendee = PropertiesReader.getUsername() + "@" + PropertiesReader.getExchangeDomain();
	  String password = PropertiesReader.getPassword();
	  
	  driver.get(PropertiesReader.getRoomManagerTabletURL());
	  
	  SettingsPage settings = new SettingsPage(driver);
	  settings.setSearchTextBox(conferenceRoom);
	  settings.selectConferenceRoom();
	  HomePage home = settings.clickAcceptButton();
	  SchedulerPage scheduler = home.clickScheduleButton();
	  scheduler.setOrganizerTextBox(organizer);
	  scheduler.setSubjectTextBox(subject);
	  scheduler.setAttendeesTextBox(attendee);
	  CredentialsPage credentials = scheduler.clickCreateButton();
	  credentials.setUsernameTextBox(organizer);
	  credentials.setPasswordTextBox(password);
	  scheduler = credentials.clickOkButton();
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
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
