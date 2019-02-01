package starter;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class BasePageObject extends PageObject{
	
	@FindBy(xpath="//*[@id=\"container\"]/div/header/div[3]/span/span[2]") WebElementFacade loginTab;
	@FindBy(css="span[class='user-name']") WebElementFacade loginNameTab;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div/div[1]/div/input") WebElementFacade loginUsernameInput;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div/div[2]/div/div/input") WebElementFacade loginPasswordInput;
	@FindBy(xpath="//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/button") WebElementFacade loginButton;
	@FindBy(css="button[title^='Detail']") List<WebElementFacade> editDetailButtons;
	@FindBy(css="tr[class=\"no-class\"] td:nth-child(1)") List<WebElementFacade> nameFields;
	@FindBy(css="tr[class=\"no-class\"] td:nth-child(2)") List<WebElementFacade> emailFields;
	@FindBy(css="tr[class=\"no-class\"] td:nth-child(3)") List<WebElementFacade> phoneFields;
	@FindBy(css="tr[class=\"no-class\"] td:nth-child(4)") List<WebElementFacade> addressFields;
	@FindBy(css="td div[style]") List<WebElementFacade> skillsFields;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/main/div/div/div[2]/div/div[2]/div[1]/div/div/input") WebElementFacade modalFirstNameInput;
	@FindBy(xpath="//*[@id=\"container\"]/div/main/div/div/div[2]/div/div[2]/div[2]/div/div/input") WebElementFacade modalLastNameInput;
	@FindBy(css="div:nth-child(3) input[type='text']") WebElementFacade modalEmailInput;
	@FindBy(css="div:nth-child(4) input[type='text']") WebElementFacade modalPhoneInput;
	@FindBy(css="div:nth-child(5) input[type='text']") WebElementFacade modalAddressInput;
	@FindBy(css="div:nth-child(6) div[class='field-container']") WebElementFacade modalSkillsInput;
	@FindBy(css="button[title='Submit']") WebElementFacade modalSubmitButton;
	@FindBy(css="button[title='Cancel']") WebElementFacade modalCancelButton;


	
	public void clickLoginTab() {
		loginTab.click();
	}
	
	public WebElementFacade getLoginNameTab() {
		return loginNameTab;
	}

	public void typeUsername(String username) {
		loginUsernameInput.type(username);
	}

	public void typePassword(String password) {
		loginPasswordInput.type(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickFirstEditDetailButton() {
		editDetailButtons.get(0).click();
	}

	public void clickFirstName() {
		nameFields.get(0).click();
	}

	public List<WebElementFacade> getSkills() {
		return skillsFields;
	}

	public void typeFirstName(String fname) {
		modalFirstNameInput.type(fname);
	}

	public void typeLastName(String lname) {
		modalLastNameInput.type(lname);
	}

	public void typeEmail(String email) {
		modalEmailInput.type(email);
	}

	public void typePhone(String phone) {
		modalPhoneInput.type(phone);
	}

	public void typeAddress(String address) {
		modalAddressInput.type(address);
	}

	public void clickSubmit() {
		modalSubmitButton.click();
	}

	public List<WebElementFacade> getNames() {
		return nameFields;
	}
	
	public List<WebElementFacade> getEmails() {
		return emailFields;
	}
	
	public List<WebElementFacade> getPhones() {
		return phoneFields;
	}
	
	public List<WebElementFacade> getAddresses() {
		return addressFields;
	}
	
	public EmployeeModel getEmployeeModelFromEditModal() {
		EmployeeModel employeeModel = new EmployeeModel(); 
		employeeModel.setAddress(modalAddressInput.getTextValue());
		employeeModel.setEmail(modalEmailInput.getTextValue());
		employeeModel.setName(modalFirstNameInput.getTextValue()+" "+modalLastNameInput.getTextValue());
		employeeModel.setPhone(modalPhoneInput.getTextValue());
		return employeeModel;
	}

}
