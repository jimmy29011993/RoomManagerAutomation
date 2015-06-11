package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailServersPage {
	WebDriver driver;
	
	By addButton = EmailServers.ADD_BUTTON.value;
	By removeButton = EmailServers.REMOVE_BUTTON.value;
	By serverButton = EmailServers.SERVER_BUTTON.value;
	
	public EmailServersPage(WebDriver driver){
		this.driver = driver;
	}
	
	public AddServerForm clickAddButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(addButton,"Add"));
		driver.findElement(addButton).click();
		return new AddServerForm(driver);
	}
	
	public ConfirmationMessageWindow clickRemoveButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(removeButton,"Remove"));
		driver.findElement(removeButton).click();
		return new ConfirmationMessageWindow(driver);
	}	
	
	public String getEmailService(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(serverButton));
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
