package org.roommanager.pages.tablet.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.home.HomeModel;
import org.roommanager.pages.tablet.scheduler.SchedulerPage;
import org.roommanager.utils.LogManager;

public class HomePage {
	WebDriver driver;
	By scheduleButton = HomeModel.SCHEDULE_BUTTON.value;
	By conferenceRoomLabel = HomeModel.CONFERENCE_ROOM_LABEL.value;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public SchedulerPage clickScheduleButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(scheduleButton));
		driver.findElement(scheduleButton).click();
		LogManager.info("Click on 'Schedule' button on Home page");
		return new SchedulerPage(driver);
	}
}
