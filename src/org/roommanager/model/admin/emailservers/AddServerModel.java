package org.roommanager.model.admin.emailservers;

import org.openqa.selenium.By;


public enum AddServerModel {
	HOSTNAME_TEXTBOX(By.xpath("//div[4]/div/div/form/div/input")),
	USERNAME_TEXTBOX(By.xpath("//div[4]/div/div/form/div[2]/input")),
	PASSWORD_TEXTBOX(By.xpath("//div[4]/div/div/form/div[3]/input")),
	SAVE_BUTTON(By.xpath("//div[4]/div/div/div[2]/button"));
	
	public final By value;
	private AddServerModel(By value){
		this.value = value;
	}
}
