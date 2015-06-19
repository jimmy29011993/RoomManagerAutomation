package org.roommanager.model.tablet.home;

import org.openqa.selenium.By;

public enum HomeModel {
	CONFERENCE_ROOM_LABEL(By.xpath("//span[2]")),
	SCHEDULE_BUTTON(By.xpath("//div/div[2]/div/div[2]"));
		
	public final By value;	
	private HomeModel(By value){
		this.value = value;
	}
}
