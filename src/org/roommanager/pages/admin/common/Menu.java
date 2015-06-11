package org.roommanager.pages.admin.common;
import org.openqa.selenium.By;
public enum Menu {
	EMAIL_SERVERS_LINK(By.linkText("Email Servers")),
	IMPERSONATION_LINK(By.linkText("Impersonation")),
	CONFERENCE_ROOMS_LINK(By.linkText("Conference Rooms")),
	RESOURCES_LINK(By.linkText("Resources")),
	LOCATIONSLINK(By.linkText("Locations"));
	
	public final By value;	
	private Menu(By value){
		this.value = value;
	}
}
