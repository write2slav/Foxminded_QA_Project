package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClientInfoPage extends BasePage {

	// Constructor
	public ClientInfoPage(WebDriver driver) {
		super(driver);
		// To do: Create assertEquals based on URL or page title check
		// assertEquals(super.configFileReader.getBaseUrl() + "admin/clients",
		// driver.getCurrentUrl());
	}
	// WebElements

	@FindBy(xpath = "//*[@id='firstName']")
	@CacheLookup
	WebElement firstNameTextField;

	@FindBy(xpath = "//*[@id='lastName']")
	@CacheLookup
	WebElement lastNameTextField;

	@FindBy(xpath = "//*[@id='email']")
	@CacheLookup
	WebElement emailTextField;

	@FindBy(xpath = "//*[@id='country']")
	@CacheLookup
	WebElement countryTextField;

	@FindBy(xpath = "//*[@id='city']")
	@CacheLookup
	WebElement cityTextField;

	@FindBy(xpath = "//*[@id='phoneNumber']")
	@CacheLookup
	WebElement phoneNumberTextField;

	@FindBy(xpath = "//*[@id='skype']")
	@CacheLookup
	WebElement skypeTextField;

	@FindBy(xpath = "//*[@id='extraFields0.value']")
	@CacheLookup
	WebElement extraSkypeTextField;

	@FindBy(xpath = "//*[@id='extraFields1.value']")
	@CacheLookup
	WebElement extraEmailTextField;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement deleteBtn;

	@FindBy(xpath = "//button[contains(text(),'Go back')]")
	@CacheLookup
	WebElement goBackBtn;

	@FindBy(xpath = "//*[contains(text(),'New')]")
	@CacheLookup
	WebElement newDealBtn;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
	@CacheLookup
	WebElement saveBtn;

	@FindBy(xpath = "//button[contains(text(),'Add Funds')]")
	@CacheLookup
	WebElement addFundsBtn;

	@FindBy(xpath = "//table[descendant::*[contains(text(),'Currency')]]")
	WebElement balanceTable;

	@FindBy(xpath = "//button[contains(text(),'Withdraw')]")
	WebElement withdrawFundsBtn;

	@FindBy(xpath = "//table[descendant::*[contains(text(),'Id')]]")
	WebElement dealsTable;

	public ClientInfoPage allElementsAreVisibleAndEnabled() {

		// Waiting until Popup is visible.
		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));

		// Displayed elements checks
		assertTrue(firstNameTextField.isDisplayed());
		assertTrue(lastNameTextField.isDisplayed());
		assertTrue(emailTextField.isDisplayed());
		assertTrue(countryTextField.isDisplayed());
		assertTrue(cityTextField.isDisplayed());
		assertTrue(phoneNumberTextField.isDisplayed());
		assertTrue(skypeTextField.isDisplayed());

		assertTrue(extraSkypeTextField.isDisplayed());
		assertTrue(extraEmailTextField.isDisplayed());

		assertTrue(deleteBtn.isDisplayed());
		assertTrue(goBackBtn.isDisplayed());
		assertTrue(newDealBtn.isDisplayed());
		assertTrue(saveBtn.isDisplayed());

		assertTrue(balanceTable.isDisplayed());
		assertTrue(addFundsBtn.isDisplayed());
		assertTrue(dealsTable.isDisplayed());

		// Enabled elements checks
		assertTrue(firstNameTextField.isEnabled());
		assertTrue(lastNameTextField.isEnabled());
		assertTrue(emailTextField.isEnabled());
		assertTrue(countryTextField.isEnabled());
		assertTrue(cityTextField.isEnabled());
		assertTrue(phoneNumberTextField.isEnabled());
		assertTrue(skypeTextField.isEnabled());

		assertTrue(extraSkypeTextField.isEnabled());
		assertTrue(extraEmailTextField.isEnabled());

		assertTrue(deleteBtn.isEnabled());
		assertTrue(goBackBtn.isEnabled());
		assertTrue(newDealBtn.isEnabled());
		assertTrue(saveBtn.isEnabled());

		assertTrue(balanceTable.isEnabled());

		assertTrue(addFundsBtn.isEnabled());

		assertTrue(dealsTable.isEnabled());

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}
	// Methods to input data into text fields

	public ClientInfoPage fillFirstNameTextField(String string) {

		firstNameTextField.clear();
		firstNameTextField.sendKeys(string);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillEmailTextField(String email) {

		emailTextField.clear();
		emailTextField.sendKeys(email);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillCountryTextField(String country) {

		countryTextField.clear();
		countryTextField.sendKeys(country);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillCityTextField(String city) {

		cityTextField.clear();
		cityTextField.sendKeys(city);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillPhoneNumberTextField(String phoneNumber) {

		phoneNumberTextField.clear();
		phoneNumberTextField.sendKeys(phoneNumber);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillSkypeTextField(String skype) {

		skypeTextField.clear();
		skypeTextField.sendKeys(skype);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillExtraSkypeTextField(String extraSkype) {

		extraSkypeTextField.clear();
		extraSkypeTextField.sendKeys(extraSkype);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientInfoPage fillExtraEmailTextField(String extraEmail) {

		extraEmailTextField.clear();
		extraEmailTextField.sendKeys(extraEmail);

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public ClientsPage saveClientInfo() {

		saveBtn.click();

		return PageFactory.initElements(driver, ClientsPage.class);
	}

	public ClientsPage deleteClient() {

		// Delete client
		deleteBtn.click();

		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='deleteForm']//button[contains(text(), 'Yes')]")));
		driver.findElement(By.xpath("//*[@id='deleteForm']//button[contains(text(), 'Yes')]")).click();

		return PageFactory.initElements(driver, ClientsPage.class);
	}

	// Methods to get values of test fields

	public String getFirstNameValue() {
		// TODO Auto-generated method stub
		return firstNameTextField.getAttribute("value");

	}

	public String getLastNameValue() {
		// TODO Auto-generated method stub
		return lastNameTextField.getAttribute("value");
	}

	public String getEmailValue() {
		// TODO Auto-generated method stub
		return emailTextField.getAttribute("value");
	}

	public String getCountryValue() {
		// TODO Auto-generated method stub
		return countryTextField.getAttribute("value");
	}

	public String getCityValue() {
		// TODO Auto-generated method stub
		return cityTextField.getAttribute("value");
	}

	public String getPhoneNumberValue() {
		// TODO Auto-generated method stub
		return phoneNumberTextField.getAttribute("value");
	}

	public String getSkypeValue() {
		// TODO Auto-generated method stub
		return skypeTextField.getAttribute("value");
	}

	public String getExtraSkypeValue() {
		// TODO Auto-generated method stub
		return extraSkypeTextField.getAttribute("value");
	}

	public String getExtraEmailValue() {
		// TODO Auto-generated method stub
		return extraEmailTextField.getAttribute("value");
	}

}
