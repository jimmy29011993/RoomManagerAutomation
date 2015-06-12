package org.roommanager.test.admin.emailserver;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.ConfirmationMessageWindow;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.signin.SignInPage;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveEmailServer {
  private static WebDriver driver = null;
  @Test
  public void removeEmailServer() {
	  LogManager.startTestCase("Register an Email Service"); 
	  String errorMessage = "The email server was not removed";
	  
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  SignInPage signIn = new SignInPage(driver);
	  LogManager.info("Sign In Room Manager App"); 
	  HomePage home = signIn.clickSignInButton();
	  LogManager.info("Click on Email Servers link"); 
	  EmailServersPage emailServers = home.clickEmailServersLink();
	  LogManager.info("Click on Remove button"); 
	  ConfirmationMessageWindow confirmationMessage = emailServers.clickRemoveButton();
	  LogManager.info("Click on Yes button"); 
	  emailServers = confirmationMessage.clickOnYesButton();
	  Assert.assertTrue(emailServers.existsEmailServerRegistered(), errorMessage);
  }
  @BeforeSuite
  public void beforeTest() {
	  driver = SeleniumDriver.chromeDriver();
  }

  @AfterSuite
  public void afterTest() {
	  driver.quit();
  }
}
