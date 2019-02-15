package starter;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.JsonObject;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class AcmeApiSteps {
	
	String baseUri = "http://api.peachthree.pac.pyramidchallenges.com/api";
	
	@Given("^I get a 200 status from GET /emps endpoint$")
	public void iGetA200StatusFromGetEmpsEndpoint() throws Throwable {
		RestAssured.baseURI = baseUri;
		Response response = SerenityRest.rest().given().when().get("/employees");
		System.out.println(response.asString());
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
	@Given("^I get a 200 status from POST /emps endpoint$")
	public void iGetA200StatusFromPostEmpsEndpoint() throws Throwable {
		RestAssured.baseURI = baseUri;
		RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
		
		JsonObject json = new JsonObject();
		json.addProperty("id", "5");
		json.addProperty("firstName", "ftest");
		json.addProperty("lastName", "ltest");
		json.addProperty("email", "");
		json.addProperty("phone", "5");
		json.addProperty("address", "5");
		json.addProperty("skills", "5");
		
//		httpRequest
//		
//		
//		Response response = SerenityRest.rest().given().when().post("/emps");
//		System.out.println(response.asString());
//		assertThat(response.getStatusCode()).isEqualTo(200);
	}

}
