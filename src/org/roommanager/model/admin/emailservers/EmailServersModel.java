package org.roommanager.model.admin.emailservers;

import org.openqa.selenium.By;

public enum EmailServersModel {
	
	ADD_BUTTON(By.xpath("//div[2]/button")),
	REMOVE_BUTTON(By.xpath("//button[2]")),
	SERVER_BUTTON(By.xpath("//div/div/a"));
	
	public final By value;	
	private EmailServersModel(By value){
		this.value = value;
	}
}
