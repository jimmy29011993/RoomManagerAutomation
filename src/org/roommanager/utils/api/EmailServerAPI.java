package org.roommanager.utils.api;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.roommanager.utils.PropertiesReader;

public class EmailServerAPI {
	private static String servicesURL = PropertiesReader.getRoomManagerBaseURL() + "/services";
	private static String serviceByIdURL = PropertiesReader.getRoomManagerBaseURL() + "/services/[serviceId]";
	private static String servicesFilter = "?type=exchange";
	private static String id = "_id";
	
	public static void removeEmailServer(String serviceId){
		String url = serviceByIdURL.replace("[serviceId]", serviceId);
		ApiRequests.delete(url);
	}
	
	public static JSONObject getEmailServer(String serviceId){
		String url = serviceByIdURL.replace("[serviceId]", serviceId);
		return ApiRequests.get(url);
	}
	
	public static JSONObject getEmailServer(){
		return getEmailServers().get(0);
	}
	
	public static ArrayList<JSONObject> getEmailServers(){
		return ApiRequests.getAll(servicesURL);
	}
	
	public static void removeAllEmailServers(){
		ArrayList<JSONObject> services = getEmailServers();
		for(int i = 0; i < services.size(); i++){
			removeEmailServer(services.get(i).get(id).toString());
		}
	}
	
	public static boolean existsEmailServer(){
		return getEmailServers().size() > 0 ? true : false;  
	}
	
	public static JSONObject registerEmailServer(String username, String password, String hostname){
		String url = servicesURL + servicesFilter;
		JSONObject payload = new JSONObject();
		payload.put("username", username);
		payload.put("password", password);
		payload.put("hostname", hostname);   
	    return ApiRequests.post(url, payload);
	}
}
