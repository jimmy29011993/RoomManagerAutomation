package org.roommanager.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.common.MenuModel;
import org.roommanager.pages.admin.emailservers.EmailServersPage;
import org.roommanager.pages.admin.impersonation.ImpersonationPage;
import org.roommanager.utils.LogManager;

public class MenuPage {

	WebDriver driver;

	By emailServersLink = MenuModel.EMAIL_SERVERS_LINK.value;
	By impersonationLink = MenuModel.IMPERSONATION_LINK.value;
	By conferenceRoomsLink = MenuModel.CONFERENCE_ROOMS_LINK.value;
	By resourcesLink = MenuModel.RESOURCES_LINK.value;
	By locationsLink = MenuModel.LOCATIONS_LINK.value;
	
	public MenuPage(WebDriver driver){
		this.driver = driver;
	}
	
	public EmailServersPage clickEmailServersLink(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(emailServersLink));
		driver.findElement(emailServersLink).click();
		LogManager.info("Select 'Email Servers' link on menu");
		return new EmailServersPage(driver);
	}
	
	public EmailServersPage clickConferenceRoomsLink(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(conferenceRoomsLink));
		driver.findElement(conferenceRoomsLink).click();
		LogManager.info("Select 'Conference Rooms' link on menu");
		return new EmailServersPage(driver);
	}
	
	public ImpersonationPage clickImpersonationLink(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(impersonationLink));
		driver.findElement(impersonationLink).click();
		LogManager.info("Select 'Impersonation' link on menu");
		return new ImpersonationPage(driver);
	}
}
