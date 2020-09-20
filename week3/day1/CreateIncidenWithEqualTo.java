package week3.day1;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class CreateIncidenWithEqualTo {
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
		.accept(ContentType.JSON)
		.post()
		.then()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.assertThat()
		//path of the Filed Name
		.body("result.short_description", equalTo("Post from RestAssured"))
		.extract().response();

		response.prettyPrint();

	}




}




