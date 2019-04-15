package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends BasePage {

	// Constructor
	public DealsPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	// Search and refresh table elements
	@FindBy(xpath = "//input[@placeholder='Поиск']")
	WebElement searchTableTextField;

	@FindBy(xpath = "//button[@title='Обновить']")
	WebElement refreshTableBtn;

	// Table header
	@FindBy(xpath = "//table/child::thead")
	WebElement dealsTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement dealsTableBody;

	public DealsPage searchTable(String string) {
		// TODO Auto-generated method stub
		searchTableTextField.sendKeys(string);

		return PageFactory.initElements(driver, DealsPage.class);
	}
}
