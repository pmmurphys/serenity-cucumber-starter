package starter.Steps;

import Models.EmployeeModel;
import Utils.DataGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.omg.CORBA.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AcmeApiSteps {

	DataGenerator dataGenerator = new DataGenerator();
	ObjectMapper objectMapper = new ObjectMapper();
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	String baseUri = variables.getProperty("baseUri");
	String baseUrl = variables.getProperty("baseUrl");
	String token = variables.getProperty("token");

	@Given("^I get a 200 status from GET (.+)$")
	public void iGetA200StatusFromGET(String endpoint) throws Throwable {
		Response response = SerenityRest
				.given()
				.header("Authorization",token)
				.baseUri(baseUri)
				.get(endpoint);
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

	@Given("^I get a 200 status from POST (.+)$")
	public void iGetA200StatusFromPOST(String endpoint) throws Throwable {
		// Create an object for serialization
		EmployeeModel employee = new EmployeeModel();
		employee.setAddress("123 test");
		employee.setEmail("test@test.com");
		employee.setId("26");
		employee.setFirstName("ftest");
		employee.setLastName("ltest");
		employee.setPhone("444-555-6666");
		employee.setSkills(Arrays.asList("test1","test2","test3"));
		// Serialize the object
		String json = objectMapper.writeValueAsString(employee);
		// POST
		Response response = SerenityRest
				.given()
				.header("Authorization",token)
				.baseUri(baseUri)
				.body(json)
				.post(endpoint);
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

	@Given("^I deserialize and store object from GET (.+)$")
	public void iDeserializeAndStoreObjectFromGET(String endpoint) throws Throwable {
		// GET response
		Response response = SerenityRest
				.given()
				.header("Authorization",token)
				.baseUri(baseUri)
				.get(endpoint);

		// Deserialize the response body
		// If single object use...
		// EmployeeModel employee = objectMapper.readValue(response.asString(),EmployeeModel.class);
		// If list of objects use...
		List<EmployeeModel> employees = objectMapper.readValue(response.asString(), new TypeReference<List<EmployeeModel>>(){});

		// Store the deserialized object(s) as a Serenity session variable.
		Serenity.setSessionVariable("employees").to(employees);

		//This can be called elsewhere in the scenario with
		// List<EmployeeModel> employees = Serenity.sessionVariableCalled("employees");
	}
}
