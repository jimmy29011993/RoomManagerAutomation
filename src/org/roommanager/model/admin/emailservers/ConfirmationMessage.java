package org.roommanager.model.admin.emailservers;

import org.openqa.selenium.By;

public enum ConfirmationMessage {
	YES_BUTTON(By.xpath("//div[3]/div/button")),
	NO_BUTTON(By.id("//div[3]/div/button[2]"));
	
	public final By value;
	private ConfirmationMessage(By value){
		this.value = value;
	}
}