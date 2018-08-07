package com.sample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Path("/")
public class RESTService {
	
	/*
	 * URL: http://localhost:8080/RestAPI/api/dns
	 * Input: Requires JSON object as a parameter
	 * Description: Parses the input JSON,
	 * 				to get the URL specified
	 * 				and Executes DnsResolver.getIP(url)
	 * 				to get the corresponding IP Address.
	 * 				Returns the result as a JSON Object
	 * */
	@POST
	@Path("/dns")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response serviceREST(InputStream incomingData) {
		StringBuilder requestData = new StringBuilder();
		String result="";
		
		// Reading the input JSON Object
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				requestData.append(line);
			}
		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(requestData.toString());
			JSONObject jsonObject2 = (JSONObject) obj;
			
			result=jsonObject2.toString();			
			String url = (String) jsonObject2.get("url");
					
			
			String ip =  DnsResolver.getIP(url);
			result =ip;
			
			// Creating JSON Response object
			JSONObject jsonResult = new JSONObject();
			jsonResult.put("url", url);
			jsonResult.put("ip", ip);
	
			result= jsonResult.toString();

			
		} catch (Exception e) {
			System.out.println("Error Parsing: - \n");
			System.out.println(e);
		}
		System.out.println("Data Received: " + requestData.toString());
		System.out.println("\n\nResponse: " + result);
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity("\nReceived Data: \n"+requestData.toString()
		+"\nServer Response:\n"+ result).build(); 
		
	}
 
	/*
	 * URL: http://localhost:8080/RestAPI/api/verify
	 * 
	 * Description: Just to check whether the API is 
	 * 				running successfully
	 * 
	 * 
	 * 
	 * */
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "RESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}