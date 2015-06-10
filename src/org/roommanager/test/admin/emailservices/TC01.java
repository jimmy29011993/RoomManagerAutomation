package org.roommanager.test.admin.emailservices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.roommanager.pages.admin.signin.SignInPage;
import org.roommanager.utils.PropertiesReader;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC01 {
  private static WebDriver driver = null;
  private PropertiesReader propReader = new PropertiesReader();
  String baseUrl;
  @Test
  public void test() {
		driver.get(baseUrl);
		SignInPage login = new SignInPage(driver);
		
		login
			.clickSignInButton()
			.clickEmailServersLink()
			.clickAddButton();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", propReader.getChromeDriverPath());
	  driver = new ChromeDriver();
	  baseUrl = propReader.getRoomManagerAdminURL();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
