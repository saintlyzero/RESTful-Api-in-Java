package com.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;

/*
 * 
 * Client Class to test the API Service
 * 
 */

public class RESTServiceClient {
	public static void main(String[] args) {

		String resp = "";
		try {

			/*
			 * Creating JSON Object for API Request
			 * 
			 * {
			 * 	"op":"DNS",
			 * 	"url":"www.google.com"
			 * }
			 * 
			 */	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("op", "DNS");
			jsonObject.put("url","www.google.com");
				
			System.out.println("CLIENT:\nSending JSON Object :\n"+jsonObject);
				
			

			try {
				URL url = new URL("http://localhost:8080/RestAPI/api/dns");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
				/*
				 * Reading the Server Response JSON Object
				 * 
				 * */
				String line="";
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				line = "";
				while ((line = in.readLine()) != null) {
					
					resp += line + "\n";
				}
				System.out.println("\n REST Service Invoked Successfully..");
				System.out.println("\nSERVER: "+resp);
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling REST Service");
				System.out.println(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
