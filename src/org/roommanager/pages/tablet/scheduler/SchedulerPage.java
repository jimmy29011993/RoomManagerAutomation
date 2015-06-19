package org.roommanager.pages.tablet.scheduler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.scheduler.SchedulerModel;
import org.roommanager.utils.LogManager;

public class SchedulerPage extends RoomTimelinePage{
	WebDriver driver;
	By organizerTextBox = SchedulerModel.ORGANIZER_TEXTBOX.value;
	By subjectTextBox = SchedulerModel.SUBJECT_TEXTBOX.value;
	By attendeesTextBox = SchedulerModel.ATTENDEES_TEXTBOX.value;
	By createButton = SchedulerModel.CREATE_BUTTON.value;
	By confirmationMessage = SchedulerModel.CONFIRMATION_MESSAGE.value;
	By removeButton = SchedulerModel.REMOVE_BUTTON.value;
	By updateButton = SchedulerModel.UPDATE_BUTTON.value;
	By bodyTextArea = SchedulerModel.BODY_TEXTAREA.value;
	By attendeesList = SchedulerModel.ATTENDEES_LIST.value;
	By attendeeText = SchedulerModel.ATTENDEE_TEXT.value;
	
	public SchedulerPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void setOrganizerTextBox(String organizer){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(organizerTextBox));
		driver.findElement(organizerTextBox).clear();
		driver.findElement(organizerTextBox).sendKeys(organizer);
		LogManager.info("Set 'Organizer' text box: " + organizer);
	}
	
	public void setSubjectTextBox(String subject){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(subjectTextBox));
		driver.findElement(subjectTextBox).clear();
		driver.findElement(subjectTextBox).sendKeys(subject);
		LogManager.info("Set 'Subject' text box: " + subject);
	}
	
	public void setAttendeesTextBox(String attendee){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(attendeesTextBox));
		driver.findElement(attendeesTextBox).clear();
		driver.findElement(attendeesTextBox).sendKeys(attendee + ";");
		LogManager.info("Set 'Attendees' text box: " + attendee);
	}
	
	public void setBodyTextArea(String body){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(bodyTextArea));
		driver.findElement(bodyTextArea).clear();
		driver.findElement(bodyTextArea).sendKeys(body);
		LogManager.info("Set 'Body' text area: " + body);
	}
	
	public CredentialsPage clickCreateButton(){
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(createButton));
		driver.findElement(createButton).click();
		LogManager.info("Click on 'Create' button");
		return new CredentialsPage(driver);
	}
	
	public String getSuccessfulMessage(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(confirmationMessage));
		LogManager.info("Retrieve the confirmation message");
		return driver.findElement(confirmationMessage).getText();
	}
	
	public void clickOnMeetingBox(String subject){
		searchSubjectOnTimeline(subject).click();
		(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(updateButton));
		LogManager.info("Click on meeting's box");
	}
	
	public CredentialsPage clickRemoveButton(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(removeButton));
		driver.findElement(removeButton).click();
		LogManager.info("Click on remove button");
		return new CredentialsPage(driver);
	}
	
	public CredentialsPage clickUpdateButton(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(updateButton));
		driver.findElement(updateButton).click();
		LogManager.info("Click on update button");
		return new CredentialsPage(driver);
	}
	
	public String getMeetingSubject(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(subjectTextBox));
		return driver.findElement(subjectTextBox).getText();
	}
	public String getMeetingBody(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(bodyTextArea));
		return driver.findElement(bodyTextArea).getText();
	}
	private WebElement searchAttendee(String attendee){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(attendeesList));
		WebElement list = driver.findElement(attendeesList);
		List<WebElement> attendees = list.findElements(attendeeText);
		for(WebElement element : attendees){
			if(element.getText().equals(attendee)){
				LogManager.info("Attendee found: " + attendee);
				return element;
			}
		}
		LogManager.info("Attendee not found: " + attendee);
		return null;
	}
	
	public boolean existAttendee(String attendee){
		return searchAttendee(attendee) != null ? true : false;
	}
	
	public String getMeetingOrganizer(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(organizerTextBox));
		return driver.findElement(organizerTextBox).getText();
	}
}
