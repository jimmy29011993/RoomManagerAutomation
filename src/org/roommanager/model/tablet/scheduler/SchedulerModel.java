package org.roommanager.model.tablet.scheduler;

import org.openqa.selenium.By;

public enum SchedulerModel {
	ORGANIZER_TEXTBOX(By.id("txtOrganizer")),
	SUBJECT_TEXTBOX(By.id("txtSubject")),
	ATTENDEES_TEXTBOX(By.xpath("//rm-tag-input/div/input")),
	CREATE_BUTTON(By.xpath("//button[4]")),
	BACK_BUTTON(By.xpath("//button"));
	
	public final By value;	
	private SchedulerModel(By value){
		this.value = value;
	}
}
