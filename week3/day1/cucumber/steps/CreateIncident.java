package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {

	public RequestSpecification request;
	
	public Response response;
	
	@Given("Set the End Point")
	public void initEndPoint() {
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
	}
	
	@And("Set the Authorization")
	public void authorize() {
		RestAssured.authentication = RestAssured.basic("admin","Z2xWNgcdCvI9");
	}
	
	@And("Set the ContentType as Json")
	public void setContentType() {
		request = RestAssured.given().contentType(ContentType.JSON);
	}
	
	@When("Send the request as Post")
	public void creatIncident() {
		response = request.post();
	}
	
	@Then("Confirm the response status code is 201")
	public void VerifyResponse() {
		System.out.println(response.getStatusCode());
	}
	
	
}
