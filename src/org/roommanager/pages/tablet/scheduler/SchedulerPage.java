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
	By confirmationMessage = SchedulerModel.CONFIRMATION_MESSAGE.value;
	By meetingBox = SchedulerModel.MEETING_BOX.value;
	By removeButton = SchedulerModel.REMOVE_BUTTON.value;
	By updateButton = SchedulerModel.UPDATE_BUTTON.value;
	By bodyTextArea = SchedulerModel.BODY_TEXTAREA.value;
	By attendeesLabel = SchedulerModel.ATTENDEES_LABEL.value;
	
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
		LogManager.info("Set 'Attendees' text box: " + attendee);
	}
	
	public void setBodyTextArea(String body){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(bodyTextArea));
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
	
	public String getSubjectOnMeetingBox(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(meetingBox));
		LogManager.info("Retrieve the subject on the meeting box");
		return driver.findElement(meetingBox).getText();
	}
	
	public void clickOnMeetingBox(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(meetingBox));
		driver.findElement(meetingBox).click();
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
	public String getMeetingAttendees(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(attendeesLabel));
		return driver.findElement(attendeesLabel).getText();
	}
	public String getMeetingOrganizer(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(organizerTextBox));
		return driver.findElement(organizerTextBox).getText();
	}
	
	/*public boolean checkMeetingUpdated(String subject, String body, String attendee){
		if(subject.equals(getMeetingSubject())){
			if(body.equals(getMeetingBody())){
				if(attendee.equals(getMeetingAttendees())){
					return true;
				}
			}
		}
		return false;
	}*/
	
	public boolean existsMeeting(String subject){
		try{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.invisibilityOfElementWithText(meetingBox, subject));
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
