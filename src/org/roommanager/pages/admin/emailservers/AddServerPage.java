package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.emailservers.AddServerModel;
import org.roommanager.utils.LogManager;

public class AddServerPage {

	WebDriver driver;
	
	By hostnameTextBox = AddServerModel.HOSTNAME_TEXTBOX.value;
	By usernameTextBox = AddServerModel.USERNAME_TEXTBOX.value;
	By passwordTextBox = AddServerModel.PASSWORD_TEXTBOX.value;
	By saveButton = AddServerModel.SAVE_BUTTON.value;
	
	public AddServerPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setHostname(String hostname){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(hostnameTextBox));
		driver.findElement(hostnameTextBox).clear();
		driver.findElement(hostnameTextBox).sendKeys(hostname);
		LogManager.info("Set the 'Hostname' text-box: " + hostname);
	}
	
	public void setUsername(String username){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
		LogManager.info("Set the 'Username' text-box: " + username);
	}
	
	public void setPassword(String password){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
		LogManager.info("Set the 'Password' text-box: " + password);
	}
	
	public EmailServersPage clickSaveButton(){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(saveButton));
		driver.findElement(saveButton).click();
		LogManager.info("Click on 'Save' button");
		return new EmailServersPage(driver);
	}
}
