package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIssue {

	@Test
	public void getAllIncident() {
		// step 1: Get EndPoint / URI
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/search";
		// step 2: Authorization
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
		// step 3: Request Type  (use Get method)
		Response response = RestAssured
				.given()
				.queryParam("jql", "project=MAY")
				.get();
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		response.prettyPrint();
		
	}
	
}
