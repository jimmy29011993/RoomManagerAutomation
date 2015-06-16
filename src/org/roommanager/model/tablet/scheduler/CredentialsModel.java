package org.roommanager.model.tablet.scheduler;

import org.openqa.selenium.By;

public enum CredentialsModel {
	USERNAME_TEXTBOX(By.xpath("//input[@type='text']")),
	PASSWORD_TEXTBOX(By.xpath("//input[@type='password']")),
	OK_BUTTON(By.xpath("//button[2]")),
	CANCEL_BUTTON(By.xpath("//button"));
	
	public final By value;	
	private CredentialsModel(By value){
		this.value = value;
	}
}
