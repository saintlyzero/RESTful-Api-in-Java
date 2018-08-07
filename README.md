# RESTful-Api-in-Java
POC of REST Api in Java by using jackson which uses JSON as Request and Response Object 
A DNS Resolver API which return the IP address of the requestes URL

**************************
Requires  Tomcat 7
**************************
JAR Files:
**************************
1) asm-all-3.3.1.jar
2) jersey-bundle-1.14.jar
3) json-simple-1.1.1.jar
4) jsr311-api-1.1.1.jar


**************************
Maven Dependencies:
**************************
	<dependencies>
		<dependency>
			<groupId>asm</groupId>
			<artifactId>asm-all</artifactId>
			<version>3.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-bundle</artifactId>
			<version>1.14</version>
		</dependency>
		<dependency>
			<groupId>com.googlecode.json-simple</groupId>
			<artifactId>json-simple</artifactId>
			<version>1.1</version>
		</dependency>
	</dependencies>

	
**************************	
Java Files:
**************************
1) RESTService
	- Creates the REST Service

2) RESTServiceClient
	- Calls the REST Service 
	- Passes JSON Object as Request

3) DnsResolver
	- Demo Functionality class
	- Resolves IP Address of the specified URL

	
**************************
API URL:
**************************

1) http://localhost:8080/RestAPI/api/dns
	- Url for the REST Api functionality
	- POST
	- Request: JSON Object
	- Eg:
	 {
		"op":"DNS",
		"url":"www.google.com"
	 }
	- Response: JSON Object
	-Eg:
	{
		"ip":"216.58.196.164",
		"url":"www.google.com"
	}

2) http://localhost:8080/RestAPI/api/verify
	- URL to check whether the API is running
	- GET
	- Response : Text
