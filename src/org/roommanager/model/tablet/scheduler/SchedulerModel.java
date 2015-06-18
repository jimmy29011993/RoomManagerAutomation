package org.roommanager.model.tablet.scheduler;

import org.openqa.selenium.By;

public enum SchedulerModel {
	ORGANIZER_TEXTBOX(By.id("txtOrganizer")),
	SUBJECT_TEXTBOX(By.id("txtSubject")),
	ATTENDEES_TEXTBOX(By.xpath("//rm-tag-input/div/input")),
	CREATE_BUTTON(By.xpath("//button[4]")),
	BACK_BUTTON(By.xpath("//button")),
	REMOVE_BUTTON(By.xpath("//button[2]")),
	UPDATE_BUTTON(By.xpath("//button[3]")),
	CONFIRMATION_MESSAGE(By.xpath("//div[2]/div[2]/div[2]/div/div[2]/div")),
	BODY_TEXTAREA(By.id("txtBody")),
	ATTENDEES_LIST(By.xpath("//li")),
	ATTENDEES_TEXT(By.xpath("span"));
	
	public final By value;	
	private SchedulerModel(By value){
		this.value = value;
	}
}
