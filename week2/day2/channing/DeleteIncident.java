package channing;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{
//path of method -> packageName.ClassName.method
	@Test(dependsOnMethods = "channing.CreateIncidentWithOutBody.createIncidentWithOutBody")
	public void deleteIncident() {
		Response response = request
		.given()
		.pathParam("ID", sys_id)
		.delete("{ID}"); 
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		response.prettyPrint();





	}

}
