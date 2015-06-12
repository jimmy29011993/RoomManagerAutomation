package org.roommanager.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.admin.common.Menu;
import org.roommanager.pages.admin.emailservers.EmailServersPage;

public class MenuPage {

	WebDriver driver;

	By emailServersLink = Menu.EMAIL_SERVERS_LINK.value;
	By impersonationLink = Menu.IMPERSONATION_LINK.value;
	By conferenceRoomsLink = Menu.CONFERENCE_ROOMS_LINK.value;
	By resourcesLink = Menu.RESOURCES_LINK.value;
	By locationsLink = Menu.LOCATIONSLINK.value;
	
	public MenuPage(WebDriver driver){
		this.driver = driver;
	}
	
	public EmailServersPage clickEmailServersLink(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(emailServersLink));
		driver.findElement(emailServersLink).click();
		return new EmailServersPage(driver);
	}
}
