package starter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.assertj.core.api.Assertions.*;

public class AcmeSteps {
	
	BasePageObject page;
	
	String baseUrl = "http://integration.peachthree.pac.pyramidchallenges.com";
	String baseUri = "http://api.peachthree.pac.pyramidchallenges.com/api";

    @Given("^i open the ACME home page$")
    public void iOpenTheACMEHomePage() throws Throwable {
    	page.openAt(baseUrl);
    }
    
    @And("^i verify that i am logged in$")
    public void iVerifyThatIAmLoggedIn() throws Throwable {
        page.clickSubmit();
    }

    @When("^i login with username (.+) and password (.+)$")
    public void iLoginWithUsernameAndPassword(String username, String password) throws Throwable {
    	page.clickLoginTab();
    	page.typeUsername(username);
    	page.typePassword(password);
    	page.clickLoginButton();
    }

    @When("^i click the edit button of the first employee$")
    public void iClickTheEditButtonOfTheFirstEmployee() throws Throwable {
        page.clickFirstEditDetailButton();
        Serenity.setSessionVariable("originalEmployeeModel").to(page.getEmployeeModelFromEditModal());
    }

    @When("^i click the name of the first employee$")
    public void iClickTheNameOfTheFirstEmployee() throws Throwable {
        page.clickFirstName();
    }

    @Then("^i verify the list of employees is visible$")
    public void iVerifyTheListOfEmployeesIsVisible() throws Throwable {
        assertThat(page.getNames().size()>0).isEqualTo(true);
        assertThat(page.getNames().get(0).getTextValue().isEmpty()).isEqualTo(false);
        assertThat(page.getEmails().get(0).getTextValue().isEmpty()).isEqualTo(false);
        assertThat(page.getPhones().get(0).getTextValue().isEmpty()).isEqualTo(false);
        assertThat(page.getAddresses().get(0).getTextValue().isEmpty()).isEqualTo(false);
    }

    @Then("^i verify that employee infomation changed$")
    public void iVerifyThatEmployeeInfomationChanged() throws Throwable { 
    	EmployeeModel originalEmployeeModel = Serenity.sessionVariableCalled("originalEmployeeModel");
    	EmployeeModel updatedEmployeeModel = Serenity.sessionVariableCalled("updatedEmployeeModel");
    	Boolean foundOriginal = false;
    	Boolean foundUpdated = false;
    	List<WebElementFacade> names = page.getNames();
    	List<WebElementFacade> emails = page.getEmails();
    	List<WebElementFacade> phones = page.getPhones();
    	List<WebElementFacade> addresses = page.getAddresses();
    	for(int i=0;i<names.size();i++) {
    		if(names.get(i).getTextValue().contains(updatedEmployeeModel.getName())) {
    			assertThat(names.get(i).getTextValue()
    					.contains(originalEmployeeModel.getName())).isEqualTo(true);
    			assertThat(emails.get(i).getTextValue()
    					.contains(originalEmployeeModel.getEmail())).isEqualTo(true);
    			assertThat(phones.get(i).getTextValue()
    					.contains(originalEmployeeModel.getPhone())).isEqualTo(true);
    			assertThat(addresses.get(i).getTextValue()
    					.contains(originalEmployeeModel.getAddress())).isEqualTo(true);
    		}
//    		if(	names.get(i).getTextValue().contains(updatedEmployeeModel.getName()) &&
//				emails.get(i).getTextValue().contains(updatedEmployeeModel.getEmail()) &&
//				phones.get(i).getTextValue().contains((updatedEmployeeModel).getPhone()) &&
//				addresses.get(i).getTextValue().contains((updatedEmployeeModel).getAddress())) {
//    				assertThat(true).overridingErrorMessage("Error! Original applicant should not exist after edit.").isEqualTo(false);
//    		}
    	}
    }

    @Then("^i verify that i can view employee skills$")
    public void iVerifyThatICanViewEmployeeSkills() throws Throwable {
        assertThat(page.getSkills().get(0).getTextValue().isEmpty()).isEqualTo(false);
    }
    
    @Given("^i fill out edit fields with random infomation")
    public void iFillOutEditFieldsWithRandomInformation() {
    	page.typeFirstName(RandomStringUtils.randomAlphabetic(10));
    	page.typeLastName(RandomStringUtils.randomAlphabetic(10));
    	page.typeEmail(RandomStringUtils.randomAlphabetic(10)+"@acme.gov");
    	page.typePhone(RandomStringUtils.randomNumeric(3)+"-"
    			+RandomStringUtils.randomNumeric(3)+"-"
    			+RandomStringUtils.randomNumeric(4));
    	page.typeAddress(RandomStringUtils.randomNumeric(3)+" "+RandomStringUtils.randomAlphabetic(10)+" Street");
    }

    @And("^i edit first name to (.+)$")
    public void iEditFirstNameTo(String fname) throws Throwable {
        page.typeFirstName(fname);
    }

    @And("^i edit last name to (.+)$")
    public void iEditLastNameTo(String lname) throws Throwable {
    	page.typeLastName(lname);
    }

    @And("^i edit email to (.+)$")
    public void iEditEmailTo(String email) throws Throwable {
    	page.typeEmail(email);
    }

    @And("^i edit phone to (.+)$")
    public void iEditPhoneTo(String phone) throws Throwable {
    	page.typePhone(phone);
    }

    @And("^i edit addess to (.+)$")
    public void iEditAddessTo(String address) throws Throwable {
        page.typeAddress(address);
    }

    @And("^i click edit submit button$")
    public void iClickEditSubmitButton() throws Throwable {
    	Serenity.setSessionVariable("updatedEmployeeModel").to(page.getEmployeeModelFromEditModal());
        page.clickSubmit();
    }
    
    @When("^i type (.+) into search input$")
    public void iTypeIntoSearchInput(String field) throws Throwable {
        page.typeIntoSearchInput(field);
    }

    @Then("^(.+) should display at the top of the list$")
    public void shouldDisplayAtTheTopOfTheList(String field) throws Throwable {
        //TO DO: API Call for all items for filter
    	//TO DO: check api call items with returned items
    	
    	//Check to make sure no irrelevant fields are shown 
    	List<WebElementFacade> names = page.getNames();
    	List<WebElementFacade> phones = page.getPhones();
    	List<WebElementFacade> emails = page.getEmails();
    	List<WebElementFacade> addresses = page.getAddresses();
    	
    	//TO DO: get the skills 
    	String skills = "Nothing";
    	
    	assertThat(names.get(0).getTextValue().contains(field) ||
    			phones.get(0).getTextValue().contains(field) ||
    			emails.get(0).getTextValue().contains(field) ||
    			addresses.get(0).getTextValue().contains(field) ||
    			skills.contains(field)).isEqualTo(true);
    		
    		
    	}
    	
//    	names.stream()
//    		.filter(x -> "bob".contains(x.getTextValue()))
//    		.findAny();
//    	
//    	for (int i = 0; i < names.size(); i++) {
//    		
//    		boolean row = false; 
//    		
//    		if (names.get(i).getTextValue().contains(field) ||
//    				names.get(i).getTextValue().contains(field)	) {
//    			row = true;
    }
    
/*    @When("^i enter (.+) into (.+) filter$")
    public void iEnterIntoFilter(String field, String filter) throws Throwable {
    	switch(filter.toLowerCase()) {
    	case "name":
    		page.typeIntoNameFilter(field);
    		break;
    	case "phone":
    		page.typeIntoPhoneFilter(field);
    		break;
    	case "email":
    		page.typeIntoEmailFilter(field);
    		break;
    	case "address":
    		page.typeIntoAddressFilter(field);
    		break;
    	}
    }

    @Then("^(.+) for the (.+) filter should be at the top of the list$")
    public void shouldBeAtTheTopOfTheList(String field, String filter) throws Throwable {
    	//API call to get field 
		RestAssured.baseURI = baseUri;
		Response response = SerenityRest.rest().given().when().get("/employees");
		
		JSONObject obj = new JSONObject(response.toString());
		List<String> list = new ArrayList<String>();
		JSONArray array = obj.getJSONArray("Bob");
		for(int i = 0 ; i < array.length() ; i++){
		    list.add(array.getJSONObject(i).getString("interestKey"));
		}
		
		
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
//		response.getBody()
*/    	
        //page.getNames();
   // }

