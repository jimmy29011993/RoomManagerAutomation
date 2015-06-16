package org.roommanager.pages.tablet.scheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.scheduler.SchedulerModel;
import org.roommanager.utils.LogManager;

public class SchedulerPage {
	WebDriver driver;
	By organizerTextBox = SchedulerModel.ORGANIZER_TEXTBOX.value;
	By subjectTextBox = SchedulerModel.SUBJECT_TEXTBOX.value;
	By attendeesTextBox = SchedulerModel.ATTENDEES_TEXTBOX.value;
	By createButton = SchedulerModel.CREATE_BUTTON.value;
	
	public SchedulerPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setOrganizerTextBox(String organizer){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(organizerTextBox));
		driver.findElement(organizerTextBox).clear();
		driver.findElement(organizerTextBox).sendKeys(organizer);
		LogManager.info("Set 'Organizer' text box: " + organizer);
	}
	
	public void setSubjectTextBox(String subject){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(subjectTextBox));
		driver.findElement(subjectTextBox).clear();
		driver.findElement(subjectTextBox).sendKeys(subject);
		LogManager.info("Set 'Subject' text box: " + subject);
	}
	
	public void setAttendeesTextBox(String attendee){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(attendeesTextBox));
		driver.findElement(attendeesTextBox).clear();
		driver.findElement(attendeesTextBox).sendKeys(attendee + ";");
		LogManager.info("Set 'Subject' text box: " + attendee);
	}
	
	public CredentialsPage clickCreateButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(createButton));
		driver.findElement(createButton).click();
		LogManager.info("Click on 'Create' button");
		return new CredentialsPage(driver);
	}
	
}
