package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.emailservers.ConfirmationMessage;

public class ConfirmationMessageWindow {

	WebDriver driver;
	
	By yesButton = ConfirmationMessage.YES_BUTTON.value;
	By noButton = ConfirmationMessage.NO_BUTTON.value;
	
	public ConfirmationMessageWindow(WebDriver driver){
		this.driver = driver;
	}
	
	public EmailServersPage clickOnYesButton(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.textToBePresentInElement(yesButton,"Yes"));
        driver.findElement(yesButton).click();
        return new EmailServersPage(driver);
	}
}
