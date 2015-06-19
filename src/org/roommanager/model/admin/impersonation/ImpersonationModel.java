package org.roommanager.model.admin.impersonation;

import org.openqa.selenium.By;

public enum ImpersonationModel {
	IMPERSONATION_CHECKBOX(By.xpath("//input[@type='checkbox']")),
	SAVE_BUTTON(By.xpath("//div[7]/div/button")),
	IMPERSONATION_TITLE(By.xpath("//label")),
	CONFIRMATION_MESSAGE(By.xpath("//div[@id='toast-container']/div/div[2]/div"));
	
	public final By value;	
	private ImpersonationModel(By value){
		this.value = value;
	}
}
