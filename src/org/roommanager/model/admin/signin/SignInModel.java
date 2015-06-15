package org.roommanager.model.admin.signin;

import org.openqa.selenium.By;

public enum SignInModel {
	SIGN_IN_BUTTON(By.xpath("//button"));
	
	public final By value;
	private SignInModel(By value){
		this.value = value;
	}
}
