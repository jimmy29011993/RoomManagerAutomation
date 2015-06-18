package org.roommanager.pages.tablet.settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.settings.SettingsModel;
import org.roommanager.pages.tablet.home.HomePage;
import org.roommanager.utils.LogManager;

public class SettingsPage {
	WebDriver driver;
	By conferenceRoomsList = SettingsModel.CONFERENCE_ROOMS_LIST.value;
	By conferenceRoomText = SettingsModel.CONFERENCE_ROOM_TEXT.value;
	By acceptButton = SettingsModel.ACCEPT_BUTTON.value;
	By cancelButton = SettingsModel.CANCEL_BUTTON.value;
	By searchTextBox = SettingsModel.SEARCH_TEXTBOX.value;
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setSearchTextBox(String room){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(searchTextBox));
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys(room);
		LogManager.info("Set 'Search' text box: " + room);
	}
	
	public void selectConferenceRoom(String room){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(conferenceRoomsList));
		List<WebElement> rooms = driver.findElements(conferenceRoomsList);
		for(WebElement element: rooms){
			if(element.findElement(conferenceRoomText).getText().equals(room)){
				LogManager.info("Select room: " + room);
				element.click();
				break;
			}
		}
		LogManager.info("Room not found: " + room);
	}
	
	public HomePage clickAcceptButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(acceptButton));
		driver.findElement(acceptButton).click();
		LogManager.info("Click on 'Accept' button");
		return new HomePage(driver);
	}

}
