package org.roommanager.model.admin.emailservers;

import org.openqa.selenium.By;

public enum EmailServers {
	
	ADD_BUTTON(By.xpath("//div[2]/button")),
	REMOVE_BUTTON(By.xpath("//button[2]")),
	SERVER_BUTTON(By.xpath("//div/div/a"));
	
	public final By value;	
	private EmailServers(By value){
		this.value = value;
	}
}
