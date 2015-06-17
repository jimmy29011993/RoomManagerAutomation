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

public class EmailServerAPI {
	
	private static String servicesURL = PropertiesReader.getRoomManagerBaseURL() + "/services";
	private static String servicesFilter = "?type=exchange";
	private static String errorMessage = "Failed : HTTP error code : ";
	private static String id = "_id";
	
	public static void removeEmailServer(String serviceId){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(servicesURL);	               
	        ClientResponse response = webResource.path(serviceId).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);	        
	        checkStatus(response.getStatus());	        
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    }
	}
	
	public static String getEmailServer(String serviceId){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(servicesURL);
	        ClientResponse response = webResource.path(serviceId).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        JSONObject responseJson = (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	        return (String)responseJson.get(id);
	        
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        return null;
	    }
	}
	
	public static String getEmailServer(){
		return getEmailServers().get(0);
	}
	
	public static ArrayList<String> getEmailServers(){
		ArrayList<String> services = new ArrayList<String>();
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(servicesURL);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        JSONArray servicesJson = (JSONArray) new JSONParser().parse(response.getEntity(String.class));
	        for (int i = 0; i < servicesJson.size(); i++){
	        	services.add((String)((JSONObject) new JSONParser().parse(servicesJson.get(i).toString())).get(id));
	        }	
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    }
		return services;
	}
	
	public static void removeAllEmailServers(){
		ArrayList<String> services = getEmailServers();
		for(int i = 0; i < services.size(); i++){
			removeEmailServer(services.get(i));
		}
	}
	
	public static boolean existsEmailServer(){
		return getEmailServers().size() > 0 ? true : false;  
	}
	
	public static String registerEmailServer(String username, String password, String hostname){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(servicesURL + servicesFilter);
	        JSONObject input = new JSONObject();
	        input.put("username", username);
	        input.put("password", password);
	        input.put("hostname", hostname);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,input.toJSONString());
	        checkStatus(response.getStatus());
	        JSONObject responseJson = (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	        return (String)responseJson.get(id);
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        return null;
	    }
	}
	
	private static void checkStatus(int status){
		if (status != 200) {
			LogManager.error(errorMessage + status);
        }
	}
}
