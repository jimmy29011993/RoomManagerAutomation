package org.roommanager.pages.admin.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.roommanager.model.admin.signin.SignInModel;
import org.roommanager.pages.admin.home.HomePage;
import org.roommanager.utils.LogManager;

public class SignInPage {
	WebDriver driver;
	
	By signInButton = SignInModel.SIGN_IN_BUTTON.value;
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
	}
	
	public HomePage clickSignInButton(){
		LogManager.info("Sign In Room Manager App");
		driver.findElement(signInButton).click();
		return new HomePage(driver);
	}
}
