package channing;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	public static RequestSpecification request;
	public static String sys_id ;
	
	@BeforeSuite
	public void initialize() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// Step 3: Request Type (use Get Method)
		request = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);
	}


}
