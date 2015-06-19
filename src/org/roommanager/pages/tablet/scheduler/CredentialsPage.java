package org.roommanager.pages.tablet.scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.scheduler.CredentialsModel;
import org.roommanager.utils.LogManager;

public class CredentialsPage {
	WebDriver driver;
	By usernameTextBox = CredentialsModel.USERNAME_TEXTBOX.value;
	By passwordTextBox = CredentialsModel.PASSWORD_TEXTBOX.value;
	By okButton = CredentialsModel.OK_BUTTON.value;
	By cancelButton = CredentialsModel.CANCEL_BUTTON.value;
	
	public CredentialsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setUsernameTextBox(String username){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
		LogManager.info("Set 'Username' text box: " + username);
	}
	
	public void setPasswordTextBox(String password){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
		LogManager.info("Set 'Password' text box: " + password);
	}
	
	public SchedulerPage clickOkButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(okButton));
		driver.findElement(okButton).click();
		LogManager.info("Click on 'Ok' button");
		(new WebDriverWait(driver,60)).until(ExpectedConditions.invisibilityOfElementLocated(okButton));
		return new SchedulerPage(driver);
	}
	
}
