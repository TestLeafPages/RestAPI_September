package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithOutBody extends BaseRequest{
	@Test
	public void createIncidentWithOutBody() {
		
		Response response = request
				.given()
				.queryParam("sysparm_fields", "sys_id,number,category")
				.post();


		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();
		//convert the response to json
		JsonPath jsonPath = response.jsonPath();

		//get sys_id
		
		sys_id = jsonPath.get("result.sys_id");
		System.out.println(sys_id);

		if (sys_id == null) {
			throw new RuntimeException("Sys_id not Found");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}




}
