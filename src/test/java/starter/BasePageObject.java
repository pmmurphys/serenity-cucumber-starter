package starter;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class BasePageObject extends PageObject{
	
	@FindBy(xpath="//*[@id=\"container\"]/div/header/div[3]/span/span[2]") WebElementFacade loginTab;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div/div[1]/div/input") WebElementFacade loginUsernameInput;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div/div[2]/div/div/input") WebElementFacade loginPasswordInput;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/button") WebElementFacade loginButton;

	public void clickLoginTab() {loginTab.click();}

	public void typeUsername(String username) {loginUsernameInput.type(username);}

	public void typePassword(String password) {loginPasswordInput.type(password);}

	public void clickLoginButton() {loginButton.click();}

}
