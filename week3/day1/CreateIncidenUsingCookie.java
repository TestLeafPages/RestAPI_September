package week3.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidenUsingCookie {
	@Test
	public void createIncidentWithOutBody() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
//		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
		// Step 3: Request Type (use Post Method + body)
		
	/*	Map<String, String> allCookies = new HashMap<String, String>();
		allCookies.put("Key", "value");
		*/
		
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.cookie("JSESSIONID","74C6D7563ECBF82C9A0F6EC6F26667E7")
				.when()
				.body("{\"short_description\" : \"Post from RestAssured\",\"category\" : \"Hardware\"}")
				.accept(ContentType.XML)
				.post();


		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();


		Map<String, String> allCookies = response.getCookies();
		
		
		String cookie = response.getCookie("JSESSIONID");
		
		//for (DataType temp : CollectionObj)
		for (Entry<String, String> eachCookies :  allCookies.entrySet()) {
			System.out.println("Name of the Cookie :"+eachCookies.getKey());
			System.out.println("Value of the Cookie :"+eachCookies.getValue());
			System.out.println("*******************************");
		}




	}




}
