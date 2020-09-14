package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident {

	@Test
	public void getAllIncident() {
		// step 1: Get EndPoint / URI
		//className.MethodName(); or className obj = new className();, obj.MethodName();
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// step 3: Request Type  (use Get method)
		Response response = RestAssured
				.given()
				.log()
				.all()
				.pathParam("ID", "f636d9fb2fb5101064df2d6df699b641")
				.delete("{ID}"); 
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		response.prettyPrint();

	
		
		
		
	}

}
