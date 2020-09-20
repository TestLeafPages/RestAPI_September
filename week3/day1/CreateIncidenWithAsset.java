package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidenWithAsset {
	@Test
	public void createIncidentWithOutBody() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// Step 3: Request Type (use Post Method + body)


		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.when()
		.body("{\"short_description\" : \"Post from RestAssured\",\"category\" : \"Hardware\"}")
		.accept(ContentType.XML)
		.post()
		.then()
		.contentType(ContentType.XML)
		.statusCode(201)
		.extract().response();

		response.prettyPrint();

	}




}




