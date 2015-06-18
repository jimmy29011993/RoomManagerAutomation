package org.roommanager.model.tablet.scheduler;

import org.openqa.selenium.By;

public enum RoomTimelineModel {
	MEETINGS_BOXES(By.xpath("div/div/div[2]/div/div")),
	ROOM_TIMELINE(By.xpath("//div[@id='timelinePanel']/rm-vis/div/div[4]"));
	public final By value;	
	private RoomTimelineModel(By value){
		this.value = value;
	}
}
