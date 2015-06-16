package org.roommanager.test.admin.emailserver;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.AddServerPage;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RegisterEmailServer {
	
  private static WebDriver driver = null;
  
  @Test
  public void registerEmailServer() {
	  
	  LogManager.startTestCase("Verify that is possible to register an Email Service"); 
	  String expected = PropertiesReader.getHostname() + "\nMicrosoft Exchange Server 2010 SP3";
	  String errorMessage = "The email server was not registered";  
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  
	  SignInPage signIn = new SignInPage(driver);
	  HomePage home = signIn.clickSignInButton();	
	  EmailServersPage emailServers = home.clickEmailServersLink();	
	  AddServerPage addServer = emailServers.clickAddButton();
	  addServer.setHostname(PropertiesReader.getHostname());
	  addServer.setUsername(PropertiesReader.getUsername());
	  addServer.setPassword(PropertiesReader.getPassword());
	  emailServers = addServer.clickSaveButton();
	  Assert.assertEquals(emailServers.getEmailServer(), expected, errorMessage);
	  LogManager.endTestCase();
  }
  @BeforeTest
  public void before(){
	  EmailServerAPI.removeAllEmailServers();
  }
  @AfterTest
  public void afterTest(){
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
