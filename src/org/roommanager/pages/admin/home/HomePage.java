package org.roommanager.pages.admin.home;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.common.AdminMenu;

public class HomePage extends AdminMenu{
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
}
