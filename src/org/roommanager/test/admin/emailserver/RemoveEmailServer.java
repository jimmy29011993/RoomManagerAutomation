package org.roommanager.test.admin.emailserver;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.ConfirmationMessageWindow;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.signin.SignInPage;
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
  @Test (priority = 1)
  public void removeEmailServer() {
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  SignInPage signIn = new SignInPage(driver);		
	  HomePage home = signIn.clickSignInButton();		
	  EmailServersPage emailServers = home.clickEmailServersLink();
	  ConfirmationMessageWindow confirmationMessage = emailServers.clickRemoveButton();
	  emailServers = confirmationMessage.clickOnYesButton();
	  Assert.assertTrue(emailServers.existsEmailServerRegistered(), "The email server was not removed");
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
