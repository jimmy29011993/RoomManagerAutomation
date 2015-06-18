package org.roommanager.pages.tablet.scheduler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.model.tablet.scheduler.RoomTimelineModel;
import org.roommanager.utils.LogManager;

public class RoomTimelinePage {
	WebDriver driver;
	By meetingsBoxes = RoomTimelineModel.MEETINGS_BOXES.value;
	By timeline = RoomTimelineModel.ROOM_TIMELINE.value;
	
	public RoomTimelinePage(WebDriver driver){
		this.driver = driver;
	}
	
	protected WebElement searchSubjectOnTimeline(String subject){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(timeline));
		WebElement time = driver.findElement(timeline);
		List<WebElement> boxes = time.findElements(meetingsBoxes);
		for(WebElement element: boxes){
			if(element.getText().equals(subject)){
				LogManager.info("Subject found: " + subject);
				return element;
			}
			
		}
		LogManager.info("Subject not found: " + subject);
		return null;
	}
	
	public boolean exitsSubjectOnTimeline(String subject){
		return searchSubjectOnTimeline(subject) != null ? true : false;
	}
	
	public void scrollTimeline(){
		
	}
}
