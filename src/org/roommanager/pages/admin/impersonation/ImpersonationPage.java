package org.roommanager.pages.admin.impersonation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.impersonation.ImpersonationModel;
import org.roommanager.pages.admin.common.MenuPage;
import org.roommanager.utils.LogManager;

public class ImpersonationPage extends MenuPage{
	WebDriver driver;
	By impersonationCheckBox = ImpersonationModel.IMPERSONATION_CHECKBOX.value;
	By saveButton = ImpersonationModel.SAVE_BUTTON.value;
	By confirmationMessage = ImpersonationModel.CONFIRMATION_MESSAGE.value;
	By impersonationTitle = ImpersonationModel.IMPERSONATION_TITLE.value;
	
	public ImpersonationPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void clickImpersonationCheckBox(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(impersonationTitle,"Exchange Server Account"));
		driver.findElement(impersonationCheckBox).click();
		LogManager.info("Click on 'Impersonation' checkbox on impersonation page");
	}
	
	public void clickSaveButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(saveButton));
		driver.findElement(saveButton).click();
		LogManager.info("Click on 'Save' button on impersonation page");
	}
	
	public String getConfirmationMessage(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(confirmationMessage));
		LogManager.info("Retrieve text of confirmation message");
		return driver.findElement(confirmationMessage).getText();
	}
}
