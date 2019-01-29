package starter;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class AcmeApiSteps {
	
	String baseUri = "http://pac-peach-two-i-951702275.us-east-2.elb.amazonaws.com/api";
	
	@Given("^I get a 200 status from /emps endpoint$")
	public void iGetA200StatusFromEmpsEndpoint() throws Throwable {
		RestAssured.baseURI = baseUri;
		Response response = SerenityRest.rest().given().when().get("/emps");
		System.out.println(response.asString());
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

}
