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

public class ConferenceRoomsAPI {
	private static String conferenceRoomsURL = PropertiesReader.getRoomManagerBaseURL() + "/services/[serviceId]/rooms";
	private static String errorMessage = "Failed : HTTP error code : ";
	private static String roomDisplayName = "displayName";
	
	public static JSONObject getConferenceRoomByName(String roomName,String serviceId){
		ArrayList<JSONObject> rooms = getAllRoomsByServiceId(serviceId);
		for(int i = 0; i < rooms.size(); i++){
			if(((String) rooms.get(i).get(roomDisplayName)).equals(roomName))
				return rooms.get(i);
		}
		return null;
	}
	
	public static ArrayList<JSONObject> getAllRoomsByServiceId(String serviceId){
		ArrayList<JSONObject> rooms = new ArrayList<JSONObject>();
		try {
			String url = conferenceRoomsURL.replace("[serviceId]", serviceId);
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        JSONArray servicesJson = (JSONArray) new JSONParser().parse(response.getEntity(String.class));
	        for (int i = 0; i < servicesJson.size(); i++){
	        	rooms.add(((JSONObject) new JSONParser().parse(servicesJson.get(i).toString())));
	        }	
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    }
		return rooms;
	}
	private static void checkStatus(int status){
		if (status != 200) {
			LogManager.error(errorMessage + status);
        }
	}
}
