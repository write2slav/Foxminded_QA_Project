package components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;
import pageObjects.ClientsPage;
import pageObjects.ClientInfoPage;

public class CreateClientPopUp extends BasePage {

	public CreateClientPopUp(WebDriver driver) {
		super(driver);
	}

	// String for Popup Xpath

	String popupXpath = "//*[@id='myModal']";

	// Pop-up window locators
	@FindBy(xpath = "//*[@id='myModal']")
	WebElement popUp;
	
	@FindBy(xpath = "//*[@id='myModal']/descendant::button[contains(text(),'×')]")
	WebElement btnClosePopUpWindow;

	@FindBy(id = "firstName")
	WebElement firstNameTextField;

	@FindBy(id = "lastName")
	WebElement lastNameTextField;

	@FindBy(xpath = "//*[@id='myModal']/descendant::button[contains(text(),'save')]")
	WebElement btnSave;

	// Page methods

	public CreateClientPopUp allElementsAreVisibleAndEnabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupXpath)));

		assertTrue(btnClosePopUpWindow.isDisplayed());
		assertTrue(firstNameTextField.isDisplayed());
		assertTrue(lastNameTextField.isDisplayed());
		assertTrue(btnClosePopUpWindow.isDisplayed());

		assertTrue(btnClosePopUpWindow.isEnabled());
		assertTrue(firstNameTextField.isEnabled());
		assertTrue(lastNameTextField.isEnabled());
		assertTrue(btnClosePopUpWindow.isEnabled());

		return new CreateClientPopUp(driver);
	}

	public ClientsPage close() {
		btnClosePopUpWindow.click();

		assertFalse(popUp.isDisplayed());
		return new ClientsPage(driver);
	}

	// Positive
	public ClientInfoPage createNewClient(String firstName, String lastName) {

		firstNameTextField.clear();
		lastNameTextField.clear();
		
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);

		btnSave.click();

		return new ClientInfoPage(driver);
	}

	// Negative testing methods
	public CreateClientPopUp createNewClientWithBlankFirstNameAndLastName() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));

		firstNameTextField.clear();
		lastNameTextField.clear();
		
		btnSave.click();

		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateClientPopUp(driver);
	}

	public CreateClientPopUp createNewClientWithBlankFirstName() {
		
		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));

		firstNameTextField.clear();
		lastNameTextField.clear();
		
		lastNameTextField.sendKeys("Test with first name only");

		btnSave.click();
		
		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateClientPopUp(driver);

	}

	public CreateClientPopUp createNewClientWithBlankLastName() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));

		firstNameTextField.clear();
		lastNameTextField.clear();
		
		firstNameTextField.sendKeys("Test with last name only");

		btnSave.click();
		
		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateClientPopUp(driver);

	}

}
