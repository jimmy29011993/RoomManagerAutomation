package org.roommanager.utils.api;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;

public class MeetingsAPI {
	private static String meetingsURL = PropertiesReader.getRoomManagerBaseURL() + "/services/[serviceId]/rooms/[roomId]/meetings";
	private static String meetingByIdURL = PropertiesReader.getRoomManagerBaseURL() + "/services/[serviceId]/rooms/[roomId]/meetings/[meetingId]";
	private static String id = "_id";
	private static String subject = "title";
	private static String emailAddress = "emailAddress";

	public static ArrayList<JSONObject> getAllMeetingsByRoom(String roomId,String serviceId){
		String url = meetingsURL.replace("[serviceId]",serviceId).replace("[roomId]", roomId);
		return ApiRequests.getAll(url);
	}
	
	public static JSONObject removeMeeting(String roomId, String meetingId, String serviceId, String username, String password){
		String url = meetingByIdURL.replace("[serviceId]",serviceId).replace("[roomId]", roomId).replace("[meetingId]", meetingId);
		return ApiRequests.deleteAuth(url, username, password);
	}
	
	public static JSONObject createMeeting(String roomName,String username,String password, String organizer, String subject, String startDate, String endDate){
		String serviceId = EmailServerAPI.getEmailServer().get(id).toString();
		JSONObject room = ConferenceRoomsAPI.getConferenceRoomByName(roomName, serviceId);
		String roomId = room.get(id).toString();
		String url = meetingsURL.replace("[serviceId]", serviceId).replace("[roomId]", roomId);
		
		JSONArray resources = new JSONArray();
        resources.add(room.get(emailAddress));
        JSONObject payload = new JSONObject();
        payload.put("organizer", username);
        payload.put("title", subject);
        payload.put("start", startDate);
        payload.put("end", endDate);
        payload.put("location", roomName);
        payload.put("roomEmail", room.get(emailAddress));
        payload.put("resources", resources);
        payload.put("attendees",null);
        
        JSONObject response = ApiRequests.postAuth(url, payload, username, password);
        if(response == null)
        	LogManager.error("API> Meeting has not been created: " + subject);
        else
        	LogManager.info("API> Meeting created: " + subject);
        return response;
	}
	
	public static void removeAllMeetingsByRoomName(String roomName, String username, String password){
		String serviceId = EmailServerAPI.getEmailServer().get(id).toString();
		JSONObject room = ConferenceRoomsAPI.getConferenceRoomByName(roomName, serviceId);
		String roomId = room.get(id).toString();
		ArrayList<JSONObject> meetings = getAllMeetingsByRoom(roomId,serviceId);
		for(int i = 0; i < meetings.size(); i++){
			String meetingId = meetings.get(i).get(id).toString();
			JSONObject response = removeMeeting(roomId, meetingId, serviceId, username, password);
			if(response == null)
				LogManager.error("API> Meeting has not been removed");
			else
				LogManager.info("API> Meeting removed: " + meetings.get(i).get(subject));
		}
	}
}
