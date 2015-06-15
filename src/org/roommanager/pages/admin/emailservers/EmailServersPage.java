package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.emailservers.EmailServersModel;
import org.roommanager.utils.LogManager;

public class EmailServersPage {
	WebDriver driver;
	
	By addButton = EmailServersModel.ADD_BUTTON.value;
	By removeButton = EmailServersModel.REMOVE_BUTTON.value;
	By serverButton = EmailServersModel.SERVER_BUTTON.value;
	
	public EmailServersPage(WebDriver driver){
		this.driver = driver;
	}
	
	public AddServerPage clickAddButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(addButton,"Add"));
		driver.findElement(addButton).click();
		LogManager.info("Click on 'Add' button on email servers page");
		return new AddServerPage(driver);
	}
	
	public ConfirmationMessagePage clickRemoveButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(removeButton,"Remove"));
		driver.findElement(removeButton).click();
		LogManager.info("Click on 'Remove' button on email servers page");
		return new ConfirmationMessagePage(driver);
	}	
	
	public String getEmailServer(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(serverButton));
		LogManager.info("Retrieve the email server");
	    return driver.findElement(serverButton).getText();
	}
	
	public boolean existsEmailServerRegistered(){
		try{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(addButton,"Add"));
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
