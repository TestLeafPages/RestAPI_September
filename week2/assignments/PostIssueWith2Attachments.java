package week2.assignments;


import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostIssueWith2Attachments {
	
	@Test
	public void getAllIssues() throws ParseException {
		
		//Step1: Define the endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		
		//Step2: set up auhentication
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "zsyrQFfc9teOn1FX3wosEDED");
		
		
		Response response = RestAssured
		.given()
		.header("Content-Type", "application/json")
		.body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"    \"project\":\r\n" + 
				"                {\r\n" + 
				"                    \"key\": \"RA\"\r\n" + 
				"                },\r\n" + 
				"    \"summary\": \"create issue in RA project\",\r\n" + 
				"    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"                    \"name\": \"Story\"\r\n" + 
				"                }\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"")
		.when()
		.post();
		
		
		
		System.out.println(response.getStatusCode());
		
		JsonPath jsonPath = response.jsonPath();
		
		String issue_id = jsonPath.get("id");
		
		
		
		
		
		//Code to attachment start here
		
		Response attachResponse = RestAssured
		.given()
		.log()
		.all()
		.header("Content-Type", "multipart/form-data")
		.header("X-Atlassian-Token", "no-check")
		.multiPart(new File("./webex_issue.jpg"))
		.multiPart(new File("./sample.png"))
		.when()
		.post(issue_id+"/attachments");
		
		System.out.println(attachResponse.getStatusCode());
		
		
		
		
		
		
		
		

	}

}
