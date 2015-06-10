package org.roommanager.pages.admin.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.roommanager.pages.admin.home.HomePage;

public class SignInPage {
	WebDriver driver;
	
	By loginButton = By.xpath("//button");
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
	}
	
	public HomePage clickSignInButton(){
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}
}
