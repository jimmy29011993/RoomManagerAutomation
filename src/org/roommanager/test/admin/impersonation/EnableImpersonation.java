package org.roommanager.test.admin.impersonation;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.impersonation.ImpersonationPage;
import org.roommanager.pages.admin.signin.SignInPage;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.roommanager.utils.api.EmailServerAPI;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Listeners({org.roommanager.utils.TestNGCustom.class})
public class EnableImpersonation {
  private static WebDriver driver = null;
  @Test
  public void enableImpersonation() {
	  LogManager.startTestCase("Make sure that is possible to impersonate Room Manager");
	  String expected = "Impersonation is now enabled.";
	  String errorMessage = "Impersonate was not enabled";  
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  
	  SignInPage signIn = new SignInPage(driver);
	  HomePage home = signIn.clickSignInButton();
	  ImpersonationPage impersonation = home.clickImpersonationLink();
	  impersonation.clickImpersonationCheckBox();
	  impersonation.clickSaveButton();
	  Assert.assertEquals(impersonation.getConfirmationMessage(), expected,errorMessage);
	  LogManager.endTestCase();
  }
  @BeforeTest
  public void beforeTest() {
	  EmailServerAPI.removeAllEmailServers();
	  EmailServerAPI.registerEmailServer(PropertiesReader.getUsername(), PropertiesReader.getPassword(),PropertiesReader.getHostname());
  }

  @AfterTest
  public void afterTest() {
	  EmailServerAPI.removeAllEmailServers();
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
