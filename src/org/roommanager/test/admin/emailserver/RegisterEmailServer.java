package org.roommanager.test.admin.emailserver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.AddServerForm;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.signin.SignInPage;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;
import org.roommanager.utils.SeleniumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RegisterEmailServer {
	
  private static WebDriver driver = null;
  
  @Test
  public void registerEmailServer() {
	  LogManager.startTestCase("Register an Email Service"); 
	  String expected = PropertiesReader.getHostname() + "\nMicrosoft Exchange Server 2010 SP2";
	  String errorMessage = "The email server was not registered";  
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  
	  SignInPage signIn = new SignInPage(driver);
	  LogManager.info("Sign In Room Manager App");
	  HomePage home = signIn.clickSignInButton();	
	  LogManager.info("Click on Email Servers link");
	  EmailServersPage emailServers = home.clickEmailServersLink();	
	  LogManager.info("Click on Add button");
	  AddServerForm addServer = emailServers.clickAddButton();
	  LogManager.info("Set Hostname text-box");
	  addServer.setHostname(PropertiesReader.getHostname());
	  LogManager.info("Set Username text-box");
	  addServer.setUsername(PropertiesReader.getUsername());
	  LogManager.info("Set Password text-box");
	  addServer.setPassword(PropertiesReader.getPassword());
	  LogManager.info("Click on Save button");
	  emailServers = addServer.clickSaveButton();
	  Assert.assertEquals(emailServers.getEmailService(), expected, errorMessage);
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
