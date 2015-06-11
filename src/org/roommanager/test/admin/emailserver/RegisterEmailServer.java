package org.roommanager.test.admin.emailserver;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.emailservers.AddServerForm;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.pages.admin.signin.SignInPage;
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
  
  @Test(priority = 0)
  public void registerEmailServer() {
	  String expected = PropertiesReader.getHostname() + "\nMicrosoft Exchange Server 2010 SP2";
	  
	  driver.get(PropertiesReader.getRoomManagerAdminURL());
	  
	  SignInPage signIn = new SignInPage(driver);		
	  HomePage home = signIn.clickSignInButton();		
	  EmailServersPage emailServers = home.clickEmailServersLink();		
	  AddServerForm addServer = emailServers.clickAddButton();		
	  addServer.setHostname(PropertiesReader.getHostname());		
	  addServer.setUsername(PropertiesReader.getUsername());		
	  addServer.setPassword(PropertiesReader.getPassword());		
	  emailServers = addServer.clickSaveButton();
	  Assert.assertEquals(emailServers.getEmailService(), expected, "The email server was not registered");	
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
