package com.sample;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
/*
 * Class to resolve IP Address
 * of the specified URL
 * 
 * */
public class DnsResolver {

	public static String getIP(String url) {
	
		String ip="";
		try {			 
			 InetAddress address = InetAddress.getByName(url);
			 ip=address.getHostAddress();
		} 
		catch (UnknownHostException e) {	
			ip="Unknown Host";
			e.printStackTrace();
		}		
		return ip;
	}

}
