package org.roommanager.utils.api;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.roommanager.utils.LogManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ApiRequests {
	private static String errorMessage = "Failed, HTTP error code : ";
	
	public static JSONObject delete(String url){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);	               
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);	        
	        checkStatus(response.getStatus());
	        return (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    	return null;
	    }
	}
	
	public static JSONObject deleteAuth(String url, String username, String password){
		try {
	        Client client = Client.create();
	        client.addFilter(new HTTPBasicAuthFilter(username,password));
	        WebResource webResource = client.resource(url);	               
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);	        
	        checkStatus(response.getStatus());
	        return (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        return null;
	    }
	}
	
	public static JSONObject get(String url){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        return (JSONObject) new JSONParser().parse(response.getEntity(String.class));  
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	        return null;
	    }
	}
	
	public static ArrayList<JSONObject> getAll(String url){
		ArrayList<JSONObject> objects = new ArrayList<JSONObject>();
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	        checkStatus(response.getStatus());
	        JSONArray servicesJson = (JSONArray) new JSONParser().parse(response.getEntity(String.class));
	        for (int i = 0; i < servicesJson.size(); i++){
	        	objects.add(((JSONObject) new JSONParser().parse(servicesJson.get(i).toString())));
	        }
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    }
		return objects;
	}
	
	public static JSONObject post(String url, JSONObject payload){
		try {
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);;
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,payload.toJSONString());
	        checkStatus(response.getStatus());
	        return (JSONObject) new JSONParser().parse(response.getEntity(String.class));
	    } catch (Exception e) {
	    	LogManager.error(e.getMessage());
	    	return null;
	    }
	}
	
	public static JSONObject postAuth(String url, JSONObject payload, String username, String password){
		try {
	        Client client = Client.create();
	        client.addFilter(new HTTPBasicAuthFilter(username,password));
	        WebResource webResource = client.resource(url);       	        
	        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,payload.toJSONString());
	        checkStatus(response.getStatus());
	        return (JSONObject) new JSONParser().parse(response.getEntity(String.class));
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
