package org.roommanager.pages.admin.signin;

import org.openqa.selenium.By;

public enum SignIn {
	SIGN_IN_BUTTON(By.xpath("//button"));
	
	public final By value;
	private SignIn(By value){
		this.value = value;
	}
}
