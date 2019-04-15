package components;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;
import pageObjects.MentorsPage;

public class CreateEmployeePopUp extends BasePage {

	// Constructor
	public CreateEmployeePopUp(WebDriver driver) {
		super(driver);
	}

	// Xpath for Popup
	String popUpXpath = "//*[@id='myModal']";

	// WebElements

	@FindBy(xpath = "//*[@id='myModal']")
	WebElement popUp;

	@FindBy(xpath = "//*[@id='myModal']/descendant::button[@class='close' and contains(text(),'×')]")
	WebElement btnClosePopUpWindow;

	@FindBy(id = "firstName")
	WebElement firstNameTextField;

	@FindBy(id = "lastName")
	WebElement lastNameTextField;

	@FindBy(id = "maxClients")
	WebElement maxLoadTextField;

	@FindBy(xpath = "//*[@id='myModal']/descendant::button[@type='submit' and contains(text(),'save')]")
	WebElement btnSave;

	// Page methods

	public MentorsPage close() {

		btnClosePopUpWindow.click();

		return new MentorsPage(driver);
	}

	public CreateEmployeePopUp allElementsAreVisibleAndEnabled() {

		// Waiting until Popup is visible.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpXpath)));

		assertTrue(btnClosePopUpWindow.isDisplayed());
		assertTrue(firstNameTextField.isDisplayed());
		assertTrue(lastNameTextField.isDisplayed());
		assertTrue(maxLoadTextField.isDisplayed());
		assertTrue(btnSave.isDisplayed());

		assertTrue(btnClosePopUpWindow.isEnabled());
		assertTrue(firstNameTextField.isEnabled());
		assertTrue(lastNameTextField.isEnabled());
		assertTrue(maxLoadTextField.isEnabled());
		assertTrue(btnSave.isEnabled());

		return new CreateEmployeePopUp(driver);
	}

	public MentorsPage createNewEmpoloyee(String firstName, String lastName, String maxLoad) {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		maxLoadTextField.clear();

		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		maxLoadTextField.sendKeys(maxLoad);
		btnSave.click();

		return new MentorsPage(driver);
	}

	// Negative testing Methods
	public CreateEmployeePopUp createNewEmpoloyeeWithEmptyFields() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		maxLoadTextField.clear();

		btnSave.click();

		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateEmployeePopUp(driver);
	}

	public CreateEmployeePopUp createNewEmpoloyeeWithEmptyFirstNameField() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		maxLoadTextField.clear();

		lastNameTextField.sendKeys("Test no name");
		maxLoadTextField.sendKeys("999");
		btnSave.click();

		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateEmployeePopUp(driver);
	}

	public CreateEmployeePopUp createNewEmpoloyeeWithEmptyLastNameField() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		maxLoadTextField.clear();

		firstNameTextField.sendKeys("Test no last name");
		maxLoadTextField.sendKeys("999");
		btnSave.click();

		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateEmployeePopUp(driver);
	}

	public CreateEmployeePopUp createNewEmpoloyeeWithEmptyMaxLoadField() {

		wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		maxLoadTextField.clear();

		firstNameTextField.sendKeys("Test no last Maxload");
		lastNameTextField.sendKeys("Test no Maxload");
		btnSave.click();

		wait.until(ExpectedConditions.visibilityOf(popUp));
		assertTrue(popUp.isDisplayed());

		return new CreateEmployeePopUp(driver);
	}

}
