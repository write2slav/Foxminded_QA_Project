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

import components.CreateClientPopUp;

public class ClientsPage extends BasePage {

	// Constructor
	public ClientsPage(WebDriver driver) {
		super(driver);
		assertEquals(super.configFileReader.getBaseUrl() + "admin/clients", driver.getCurrentUrl());
	}

	// String xpath for

	// Web elements
	// New consultancy button
	@FindBy(xpath = "//*[@id='fixed-table-toolbar--buttons']/button[contains(text(),'Create Client')]")
	@CacheLookup
	WebElement newConsutancyBtn;

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
	WebElement clientsTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement clientsTableBody;

	public CreateClientPopUp clickOnCreateClientButton() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(newConsutancyBtn));
		newConsutancyBtn.click();

		return PageFactory.initElements(driver, CreateClientPopUp.class);
	}

	public ClientsPage allElementsAreVisibleAndEnabled() {

		wait.until(ExpectedConditions.visibilityOf(clientsTableBody));

		assertTrue(newConsutancyBtn.isDisplayed());
		assertTrue(searchTableTextField.isDisplayed());
		assertTrue(refreshTableBtn.isDisplayed());

		assertTrue(newConsutancyBtn.isEnabled());
		assertTrue(searchTableTextField.isEnabled());
		assertTrue(refreshTableBtn.isEnabled());

		return PageFactory.initElements(driver, ClientsPage.class);
	}

	public ClientsPage searchClientByFirstAndLastName(String firstName, String lastname) {

		searchTableTextField.sendKeys(firstName + " " + lastname);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.print(e);

		}
		// To do: think of the wait that can be used when dealing with dynamic table
		// wait.until(ExpectedConditions
		// .invisibilityOf(clientsTableBody.findElement(By.xpath("./child::tr[2]/child::td[2]/a"))));

		return PageFactory.initElements(driver, ClientsPage.class);
	}

	public ClientInfoPage goToClientInfoPage() {

		clientsTableBody.findElement(By.xpath("./child::tr[1]/child::td[2]/a")).click();

		return PageFactory.initElements(driver, ClientInfoPage.class);
	}

	public Boolean hasNoClientsListed() {
		// TODO Auto-generated method stub
		System.out.println(clientsTableBody.findElements(By.xpath("./tr")).size());

		return clientsTableBody.findElements(By.xpath("./tr")).get(0).getText().equals("Ничего не найдено");

	}
}
