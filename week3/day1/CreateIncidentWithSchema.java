package week3.day1;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithSchema {

	@Test
	public void createIncident() {
		// step 1: post EndPoint / URI
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// step 3: Request Type  (use Put method)
		
		File jsonFile = new File("./CreateIncident.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat()
				.body(matchesJsonSchema(jsonFile))
				.extract().response()
				; 
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		response.prettyPrint();
		
		
		
		
		
		
		
		
	}
	
}
