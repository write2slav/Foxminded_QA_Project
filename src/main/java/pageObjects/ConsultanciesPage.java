package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConsultanciesPage extends BasePage {

	// Constructor
	public ConsultanciesPage(WebDriver driver) {
		super(driver);
		assertEquals(super.configFileReader.getBaseUrl() + "admin/consultancies", driver.getCurrentUrl());

	}

	// Web elements

	@FindBy(xpath = "//*[@id='fixed-table-toolbar--buttons']/*[contains(text(), 'New consultancy')]")
	@CacheLookup
	WebElement createClientBtn;

	// Search and refresh table elements
	@FindBy(xpath = "//input[@placeholder='Поиск']")
	@CacheLookup
	WebElement searchTableTextField;

	@FindBy(xpath = "//button[@title='Обновить']")
	@CacheLookup
	WebElement refreshTableBtn;

	// Table header
	@FindBy(xpath = "//table/child::thead")
	@CacheLookup
	WebElement consultancyTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement consultancyTableBody;

	public ConsultancyInfoPage clickOnCreateConsultancyButton() {

		wait.until(ExpectedConditions.visibilityOf(createClientBtn));
		createClientBtn.click();

		return PageFactory.initElements(driver, ConsultancyInfoPage.class);
	}

	public ConsultanciesPage allElementsAreVisibleAndEnabled() {
		wait.until(ExpectedConditions.visibilityOf(createClientBtn));

		assertTrue(createClientBtn.isDisplayed());
		assertTrue(searchTableTextField.isDisplayed());
		assertTrue(refreshTableBtn.isDisplayed());

		assertTrue(createClientBtn.isEnabled());
		assertTrue(searchTableTextField.isEnabled());
		assertTrue(refreshTableBtn.isEnabled());

		return PageFactory.initElements(driver, ConsultanciesPage.class);
	}

	public ConsultanciesPage searchConsultancyBy(String string) {

		searchTableTextField.sendKeys(string);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
			System.out.print(e);
		}
		// To do: think of the wait that can be used when dealing with dynamic table
		// wait.until(ExpectedConditions
		// .invisibilityOf(clientsTableBody.findElement(By.xpath("./child::tr[2]/child::td[2]/a"))));

		return PageFactory.initElements(driver, ConsultanciesPage.class);
	}

	public ConsultancyInfoPage goToConsultancyInfoPage() {

		consultancyTableBody.findElement(By.xpath("./child::tr[1]/child::td[2]/a")).click();

		return PageFactory.initElements(driver, ConsultancyInfoPage.class);

	}

	public Boolean hasNoConsultanciesListed() {
		// TODO Auto-generated method stub
		System.out.println(consultancyTableBody.findElements(By.xpath("./tr")).size());

		return consultancyTableBody.findElements(By.xpath("./tr")).get(0).getText().equals("Ничего не найдено");
	}

}
