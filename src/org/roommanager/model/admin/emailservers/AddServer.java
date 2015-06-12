package org.roommanager.model.admin.emailservers;

import org.openqa.selenium.By;


public enum AddServer {
	HOSTNAME_TEXTBOX(By.id("add-mailserver-hostname")),
	USERNAME_TEXTBOX(By.id("add-mailserver-username")),
	PASSWORD_TEXTBOX(By.id("add-mailserver-password")),
	SAVE_BUTTON(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary"));
	
	public final By value;
	private AddServer(By value){
		this.value = value;
	}
}
