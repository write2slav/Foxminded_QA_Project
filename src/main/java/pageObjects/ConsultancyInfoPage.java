package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConsultancyInfoPage extends BasePage {

	// Constructor
	public ConsultancyInfoPage(WebDriver driver) {
		super(driver);
	}

	// WebElements

	@FindBy(id = "name")
	WebElement titleTextField;

	@FindBy(id = "description")
	WebElement descriptionTextField;

	@FindBy(id = "prices[0].amount")
	WebElement priceUahTextField;

	@FindBy(id = "prices[1].amount")
	WebElement priceEurTextField;

	@FindBy(id = "prices[2].amount")
	WebElement priceUsdTextField;

	@FindBy(id = "employeeRate.amount")
	WebElement employeeRateAmountTextField;

	@FindBy(xpath = "//button[@data-target=\"#deleteConfirmationForm\" and contains(text(),'Delete')]")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[@onclick=\"history.back();\" and contains(text(),'Go back')]	")
	WebElement goBackBtn;

	@FindBy(xpath = "//button[@onclick=\"$('#saveConsultancy').submit()\" and contains(text(),'Save')]")
	WebElement saveBtn;

	// Page methods

	public ConsultancyInfoPage allElementsAreVisibleAndEnabled() {

		// Waiting until Popup is visible.
		wait.until(ExpectedConditions.visibilityOf(titleTextField));

		// Displayed elements checks
		assertTrue(titleTextField.isDisplayed());
		assertTrue(descriptionTextField.isDisplayed());
		assertTrue(priceUahTextField.isDisplayed());
		assertTrue(priceEurTextField.isDisplayed());
		assertTrue(priceUsdTextField.isDisplayed());
		assertTrue(employeeRateAmountTextField.isDisplayed());

		assertTrue(deleteBtn.isDisplayed());
		assertTrue(goBackBtn.isDisplayed());
		assertTrue(saveBtn.isDisplayed());

		// Enabled elements checks
		assertTrue(titleTextField.isEnabled());
		assertTrue(descriptionTextField.isEnabled());
		assertTrue(priceUahTextField.isEnabled());
		assertTrue(priceEurTextField.isEnabled());
		assertTrue(priceUsdTextField.isEnabled());
		assertTrue(employeeRateAmountTextField.isEnabled());

		assertTrue(deleteBtn.isEnabled());
		assertTrue(goBackBtn.isEnabled());
		assertTrue(saveBtn.isEnabled());

		return PageFactory.initElements(driver, ConsultancyInfoPage.class);
	}

	public ConsultanciesPage createNewConsultancy(String name, String description, String priceUah, String priceUsd,
			String priceEur, String rate) {

		titleTextField.clear();
		descriptionTextField.clear();
		priceUahTextField.clear();
		priceUsdTextField.clear();
		priceEurTextField.clear();
		employeeRateAmountTextField.clear();

		titleTextField.sendKeys(name);
		descriptionTextField.sendKeys(description);
		priceUahTextField.sendKeys(priceUah);
		priceUsdTextField.sendKeys(priceUsd);
		priceEurTextField.sendKeys(priceEur);
		employeeRateAmountTextField.sendKeys(rate);

		saveBtn.click();

		return PageFactory.initElements(driver, ConsultanciesPage.class);
	}

	public ConsultanciesPage deleteConsultancy() {
		
		deleteBtn.click();
		
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='deleteForm']//button[contains(text(), 'Yes')]")));
		driver.findElement(By.xpath("//*[@id='deleteForm']//button[contains(text(), 'Yes')]")).click();
		
		return PageFactory.initElements(driver, ConsultanciesPage.class);
	}

	public String getName() {
		return titleTextField.getAttribute("value");
	}

	public String getDescription() {
		return descriptionTextField.getAttribute("value");
	}

	public String getPriceUah() {
		return priceUahTextField.getAttribute("value");
	}

	public String getPriceUsd() {
		return priceUsdTextField.getAttribute("value");
	}

	public String getPriceEur() {
		return priceEurTextField.getAttribute("value");
	}

	public String getEmployeeRateAmount() {
		return employeeRateAmountTextField.getAttribute("value");
	}
}
