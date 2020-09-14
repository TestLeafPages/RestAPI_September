package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncident {

	@Test
	public void getAllIncident() {
		// step 1: Get EndPoint / URI
		//className.MethodName(); or className obj = new className();, obj.MethodName();
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident/eca44a802f87d01064df2d6df699b695";
		// step 2: Authorization
//		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		
//		RestAssured.authentication = RestAssured.oauth2("y9XniISArfDYko6t83O0B6XnkbGuXi5TQyEeJ55rMEJtW08Sfwuuw8cGidtTlD6Vv8DNgF3oR_c2xiDlAgbivA");
		
		
		// step 3: Request Type  (use Get method)
		Response response = RestAssured
				.given()
				.header(new Header("Authorization", "Bearer y9XniISArfDYko6t83O0B6XnkbGuXi5TQyEeJ55rMEJtW08Sfwuuw8cGidtTlD6Vv8DNgF3oR_c2xiDlAgbivA"))		
				.header(new Header("Accept", "application/xml"))
//				.headers(map)
				.get(); // ctrl+2, l
		// step 4: validate response code (200)
		System.out.println(response.getStatusCode());
		// step 5: validate formate
		System.out.println(response.getContentType());
		// step 6 : print the response
		response.prettyPrint();

		/*//convert the response to json
		JsonPath jsonPath = response.jsonPath();

		//get sys_id
		List<String> listOfSys_id = jsonPath.getList("result.sys_id");

		System.out.println(listOfSys_id);
		*/
		
		
		/*for (String eachId : listOfSys_id) {
			System.out.println(eachId);
		}*/
	}

}
