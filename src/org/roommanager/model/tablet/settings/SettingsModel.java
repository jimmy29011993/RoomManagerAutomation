package org.roommanager.model.tablet.settings;

import org.openqa.selenium.By;

public enum SettingsModel {
	CONFERENCE_ROOM(By.xpath("//div[3]/div/div/div")),
	SEARCH_TEXTBOX(By.id("txtSearch")),
	ACCEPT_BUTTON(By.xpath("//button")),
	CANCEL_BUTTON(By.xpath("//button[2]"));
	
	public final By value;	
	private SettingsModel(By value){
		this.value = value;
	}
}
