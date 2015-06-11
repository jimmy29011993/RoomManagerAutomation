package org.roommanager.pages.admin.home;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.common.MenuPage;

public class HomePage extends MenuPage{
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
}
