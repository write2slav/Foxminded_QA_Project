package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
		// Validating page title
		assertEquals("Foxminded Accounting System", driver.getTitle());
	}

	// Constructor

	// Page web elements

	@FindBy(id = "login-form-link")
	WebElement loginTab;

	@FindBy(id = "username")
	WebElement usernameTextField;

	@FindBy(id = "password")
	WebElement passwordTextField;

	@FindBy(id = "login-submit")
	WebElement loginBtn;

	@FindBy(id = "register-form-link")
	WebElement registerTab;

	@FindBy(id = "register-username")
	WebElement registerUsernameTextField;

	@FindBy(id = "register-password")
	WebElement registerPasswordTextField;

	@FindBy(id = "email")
	WebElement registerEmailTextField;

	@FindBy(id = "email")
	WebElement registerBtn;

	// Click on Login tab
	public void clickOnLoginTab() {

		loginTab.click();
	}

	// Login using username and password
	public DashboardPage loginWithCredentials(String username, String password) {
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		usernameTextField.sendKeys(username);
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(passwordTextField));
		passwordTextField.sendKeys(password);
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.click();

		return PageFactory.initElements(driver, DashboardPage.class);
	}

	// Click on Register tab
	public void clickOnRegisterTab() {

		registerTab.click();
	}

	// Registering using username, password and email
	public LoginPage registerUser(String username, String password, String email) {
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(registerUsernameTextField));
		registerUsernameTextField.sendKeys(username);
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(registerPasswordTextField));
		registerPasswordTextField.sendKeys(password);
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(registerEmailTextField));
		registerEmailTextField.sendKeys(email);
		// Waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOf(registerBtn));
		registerBtn.click();

		return PageFactory.initElements(driver, LoginPage.class);
	}
}
