package org.roommanager.pages.tablet.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.settings.SettingsModel;
import org.roommanager.pages.tablet.home.HomePage;
import org.roommanager.utils.LogManager;

public class SettingsPage {
	WebDriver driver;
	
	By conferenceRoom = SettingsModel.CONFERENCE_ROOM.value;
	By acceptButton = SettingsModel.ACCEPT_BUTTON.value;
	By cancelButton = SettingsModel.CANCEL_BUTTON.value;
	By searchTextBox = SettingsModel.SEARCH_TEXTBOX.value;
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setSearchTextBox(String conferenceRoom){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(searchTextBox));
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys(conferenceRoom);
		LogManager.info("Set 'Search' text box: " + conferenceRoom);
	}
	
	public void selectConferenceRoom(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(conferenceRoom));
		driver.findElement(conferenceRoom).click();
		LogManager.info("Select the conference room");
	}
	
	public HomePage clickAcceptButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(acceptButton));
		driver.findElement(acceptButton).click();
		LogManager.info("Click on 'Accept' button");
		return new HomePage(driver);
	}

}
