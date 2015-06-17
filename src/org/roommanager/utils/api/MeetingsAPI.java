package org.roommanager.utils.api;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.roommanager.utils.LogManager;
import org.roommanager.utils.PropertiesReader;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class MeetingsAPI {
	private static String meetingsURL = PropertiesReader.getRoomManagerBaseURL() + "/services/[serviceId]/rooms/[roomId]/meetings";
	private static String errorMessage = "Failed : HTTP error code : ";
	private static String id = "_id";
	private static String emailAddress = "emailAddress";

	public static ArrayList<JSONObject> getAllMeetingsByRoom(String roomId,String serviceId){
		ArrayList<JSONObject> meetings = new ArrayList<JSONObject>();
		try {
			String url = meetingsURL.replace("[serviceId]", serviceId).replace("[roomId]",roomId);
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        JSONArray servicesJson = (JSONArray) new JSONParser().parse(response.getEntity(String.class));
	        for (int i = 0; i < servicesJson.size(); i++){
	        	meetings.add(((JSONObject) new JSONParser().parse(servicesJson.get(i).toString())));
	        }	
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        e.printStackTrace();
	    }
		return meetings;
	}
	
	public static void removeMeeting(String roomId, String meetingId, String serviceId, String username, String password){
		try {
			String url = meetingsURL.replace("[serviceId]", serviceId).replace("[roomId]",roomId);
	        Client client = Client.create();
	        client.addFilter(new HTTPBasicAuthFilter(username,password));
	        WebResource webResource = client.resource(url);	               
	        ClientResponse response = webResource.path(meetingId).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);	        
	        checkStatus(response.getStatus());	        
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public static String createMeeting(String roomName,String username,String password, String organizer, String subject, String startDate, String endDate){
		try {
			String serviceId = EmailServerAPI.getEmailServer();
			JSONObject room = ConferenceRoomsAPI.getConferenceRoomByName(roomName, serviceId);
			String url = meetingsURL.replace("[serviceId]", serviceId).replace("[roomId]",(CharSequence) room.get(id));
	        Client client = Client.create();
	        client.addFilter(new HTTPBasicAuthFilter(username,password));
	        WebResource webResource = client.resource(url);
	        
	        JSONArray resources = new JSONArray();
	        resources.add(room.get(emailAddress));
	        
	        JSONObject input = new JSONObject();
	        input.put("organizer", username);
	        input.put("title", subject);
	        input.put("start", startDate);
	        input.put("end", endDate);
	        input.put("location", roomName);
	        input.put("roomEmail", room.get(emailAddress));
	        input.put("resources", resources);
	        input.put("attendees",null);	        
	        
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,input.toJSONString());
	        checkStatus(response.getStatus());
	        JSONObject responseJson = (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	        return (String)responseJson.get(id);
	        
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        return null;
	    }
	}
	
	public static void removeAllMeetingsByRoomName(String roomName, String username, String password){
		String serviceId = EmailServerAPI.getEmailServer();
		JSONObject room = ConferenceRoomsAPI.getConferenceRoomByName(roomName, serviceId);
		String roomId = room.get(id).toString();
		ArrayList<JSONObject> meetings = getAllMeetingsByRoom(roomId,serviceId);
		for(int i = 0; i < meetings.size(); i++){
			String meetingId = meetings.get(i).get(id).toString();
			removeMeeting(roomId, meetingId, serviceId, username, password);
		}
	}
	
	private static void checkStatus(int status){
		if (status != 200) {
            LogManager.error(errorMessage + status);
        }
	}
}
