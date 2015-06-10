package org.roommanager.pages.admin.emailservers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailServersPage {
	WebDriver driver;
	
	By addButton = By.xpath("//div[2]/button");
	
	public EmailServersPage(WebDriver driver){
		this.driver = driver;
	}
	
	public AddServerForm clickAddButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.textToBePresentInElement(addButton,"Add"));
		driver.findElement(addButton).click();
		return new AddServerForm(driver);
	}
}
