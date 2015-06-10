package org.roommanager.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pages.admin.emailservers.EmailServersPage;

public class AdminMenu {

	WebDriver driver;
	
	By emailServersLink = By.linkText("Email Servers");
	By impersonationLink = By.linkText("Impersonation");
	By conferenceRoomsLink = By.linkText("Conference Rooms");
	By resourcesLink = By.linkText("Resources");
	By locationsLink = By.linkText("Locations");
	
	public AdminMenu(WebDriver driver){
		this.driver = driver;
	}
	
	public EmailServersPage clickEmailServersLink(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(emailServersLink));
		driver.findElement(emailServersLink).click();
		return new EmailServersPage(driver);
	}
}
