package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.emailservers.ConfirmationMessageModel;
import org.roommanager.utils.LogManager;

public class ConfirmationMessagePage {

	WebDriver driver;
	
	By yesButton = ConfirmationMessageModel.YES_BUTTON.value;
	By noButton = ConfirmationMessageModel.NO_BUTTON.value;
	
	public ConfirmationMessagePage(WebDriver driver){
		this.driver = driver;
	}
	
	public EmailServersPage clickOnYesButton(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.textToBePresentInElement(yesButton,"Yes"));
        driver.findElement(yesButton).click();
        LogManager.info("Click on 'Yes' button to confirm the operation");
        return new EmailServersPage(driver);
	}
}
