package org.roommanager.model.tablet.scheduler;

import org.openqa.selenium.By;

public enum CredentialsModel {
	USERNAME_TEXTBOX(By.xpath("//input")),
	PASSWORD_TEXTBOX(By.xpath("//div[2]/div/div/input")),
	OK_BUTTON(By.xpath("(//button[@type='button'])[2]")),
	CANCEL_BUTTON(By.xpath("//button"));
	
	public final By value;	
	private CredentialsModel(By value){
		this.value = value;
	}
}
