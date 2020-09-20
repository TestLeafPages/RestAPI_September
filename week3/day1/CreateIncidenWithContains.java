package week3.day1;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class CreateIncidenWithContains {
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
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id,number")
		.queryParam("sysparm_limit", "1")
		.get()
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.assertThat()
		.body("result.number", hasItem("INC0009002"))
		//hasItem -> Array
		//containsString -> String
		
		.extract().response();

		response.prettyPrint();

	}




}




