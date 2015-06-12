package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.emailservers.AddServer;

public class AddServerForm {

	WebDriver driver;
	
	By hostnameTextBox = AddServer.HOSTNAME_TEXTBOX.value;
	By usernameTextBox = AddServer.USERNAME_TEXTBOX.value;
	By passwordTextBox = AddServer.PASSWORD_TEXTBOX.value;
	By saveButton = AddServer.SAVE_BUTTON.value;
	
	public AddServerForm(WebDriver driver){
		this.driver = driver;
	}
	
	public void setHostname(String hostname){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(hostnameTextBox));
		driver.findElement(hostnameTextBox).clear();
		driver.findElement(hostnameTextBox).sendKeys(hostname);
	}
	
	public void setUsername(String username){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void setPassword(String password){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public EmailServersPage clickSaveButton(){
		(new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(saveButton));
		driver.findElement(saveButton).click();
		return new EmailServersPage(driver);
	}
}
