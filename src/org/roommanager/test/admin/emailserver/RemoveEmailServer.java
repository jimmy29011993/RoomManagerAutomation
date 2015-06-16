package org.roommanager.test.admin.emailserver;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.ConfirmationMessagePage;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.signin.SignInPage;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.roommanager.utils.api.EmailServerAPI;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RemoveEmailServer {
	
  private static WebDriver driver = null;
  
  @Test
  public void removeEmailServer(){
	  
	  LogManager.startTestCase("Verify that is possible to remove an Email Service"); 
	  String errorMessage = "The email server was not removed";
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  
	  SignInPage signIn = new SignInPage(driver);
	  HomePage home = signIn.clickSignInButton();
	  EmailServersPage emailServers = home.clickEmailServersLink();
	  ConfirmationMessagePage confirmationMessage = emailServers.clickRemoveButton();
	  emailServers = confirmationMessage.clickOnYesButton();
	  Assert.assertTrue(emailServers.existsEmailServerRegistered(), errorMessage);
	  LogManager.endTestCase();
  }
  
  @BeforeTest
  public void beforeTest(){
	  EmailServerAPI.removeAllEmailServers();
	  EmailServerAPI.registerEmailServer(PropertiesReader.getUsername(), PropertiesReader.getPassword(),PropertiesReader.getHostname());
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
