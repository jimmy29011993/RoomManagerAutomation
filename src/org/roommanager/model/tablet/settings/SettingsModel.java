package org.roommanager.model.tablet.settings;

import org.openqa.selenium.By;

public enum SettingsModel {
	SEARCH_TEXTBOX(By.id("txtSearch")),
	ACCEPT_BUTTON(By.xpath("//button[1]")),
	CANCEL_BUTTON(By.xpath("//button[2]")),
	CONFERENCE_ROOMS_LIST(By.xpath("//div[3]/div/div/div")),
	CONFERENCE_ROOM_TEXT(By.xpath("h4"));
	
	public final By value;	
	private SettingsModel(By value){
		this.value = value;
	}
}
