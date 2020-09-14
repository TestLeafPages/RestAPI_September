package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncident {

	@Test
	public void createIncident() {
		// step 1: post EndPoint / URI
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// step 3: Request Type  (use Put method)
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post(); 
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		//response.prettyPrint();
		
		//convert the response to json
		JsonPath jsonPath = response.jsonPath();
		
		//get sys_id
		String sys_id = jsonPath.get("result.sys_id");
		System.out.println(sys_id);
		
		
		
		
		
		
		
		
	}
	
}
