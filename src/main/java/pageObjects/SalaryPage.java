package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryPage extends BasePage {

	// Constructor
	public SalaryPage(WebDriver driver) {
		super(driver);
	}

	// Web elements
	// Search and refresh table elements
	@FindBy(xpath = "//input[@placeholder='Поиск']")
	WebElement searchTableTextField;

	@FindBy(xpath = "//button[@title='Обновить']")
	WebElement refreshTableBtn;

	// Table header
	@FindBy(xpath = "//table/child::thead")
	WebElement usersTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement usersTableBody;

}
