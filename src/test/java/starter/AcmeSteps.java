package starter;

import cucumber.api.java.en.*;

public class AcmeSteps {
	
	BasePageObject page;
	
	String baseUrl = "http://peach-two.pyramidchallenges.com.s3-website.us-east-2.amazonaws.com/";

    @Given("^i open the ACME home page$")
    public void iOpenTheACMEHomePage() throws Throwable {
    	page.openAt(baseUrl);
    }

    @When("^i login with username (.+) and password (.+)$")
    public void iLoginWithUsernameAndPassword(String username, String password) throws Throwable {
    	page.clickLoginTab();
    	page.typeUsername(username);
    	page.typePassword(password);
    	page.clickLoginButton();
    }

    @Then("^i should be on the homepage$")
    public void iShouldBeOnTheHomepage() throws Throwable {
        
    }

}
