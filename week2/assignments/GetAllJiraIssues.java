package week2.assignments;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllJiraIssues {
	
	@Test
	public void getAllIssues() throws ParseException {
		
		//Step1: Define the endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/";
		
		//Step2: set up auhentication
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "zsyrQFfc9teOn1FX3wosEDED");
		
		Response response = RestAssured.get("search");
		
		System.out.println(response.getStatusCode());
		
		JsonPath jsonPath = response.jsonPath();
		
		int countBeforeDelete = jsonPath.get("total");
		
		System.out.println("Count Before Delete: "+countBeforeDelete);
		
		//response.prettyPrint();
		
		List<String> listdates = jsonPath.getList("issues.fields.created");
		
		for (int i = 0; i < listdates.size(); i++) {
			
			DateFormat format  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				
			List<String> listCreatedTime = jsonPath.getList("issues.fields.created");
			Date date = format.parse(listCreatedTime.get(i));
			
			
			
			long createdTime = date.getTime();
			
			long currentTime = new Date().getTime();
			
						
			if (currentTime - createdTime <= (24*60*60*1000)) {
				
				String issue_id = (String) jsonPath.getList("issues.id").get(i);
				
				System.out.println(issue_id);
			}
			
			
			
			
					
			
		}
		
		int count = listdates.size();
		
		// step to create random index	
				int ranNum = 	(int) (Math.random() * count);
				
				String ranId = (String) jsonPath.getList("issues.id").get(ranNum);
				
				
				Response deleteResponse = RestAssured.given().log().all().delete("issue/"+ranId);
				
				System.out.println(deleteResponse.getStatusCode());
				
				
				
				Response responseAfterDelete = RestAssured.get("search");
				JsonPath jsonPath2 = responseAfterDelete.jsonPath();
				int countAfterDelete = jsonPath2.get("total");
				
				System.out.println("Count After Delete: "+countAfterDelete);
				
				
				
		
		

	}

}
