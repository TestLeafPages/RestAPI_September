package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class UpdateIncident {
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
				.accept(ContentType.XML)
				.when()
				.body("{\"short_description\" : \"Update from RestAssured\",\"category\" : \"Software\"}")
				.pathParam("sys_id", "eca44a802f87d01064df2d6df699b695")
				.put("{sys_id}");


		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();


		//convert the response to XML
		XmlPath xmlPath = response.xmlPath();

		//get sys_id
		List<String> listShort_description = xmlPath.getList("response.result.short_description");

		System.out.println(listShort_description.get(0));






	}




}
