package org.roommanager.model.admin.common;
import org.openqa.selenium.By;
public enum MenuModel {
	EMAIL_SERVERS_LINK(By.linkText("Email Servers")),
	IMPERSONATION_LINK(By.linkText("Impersonation")),
	CONFERENCE_ROOMS_LINK(By.linkText("Conference Rooms")),
	RESOURCES_LINK(By.linkText("Resources")),
	LOCATIONS_LINK(By.linkText("Locations"));
	
	public final By value;	
	private MenuModel(By value){
		this.value = value;
	}
}
