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
		String url = conferenceRoomsURL.replace("[serviceId]", serviceId);
		return ApiRequests.getAll(url);
	}
}
