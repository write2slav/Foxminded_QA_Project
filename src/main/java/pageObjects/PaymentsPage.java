package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends BasePage {

	// Constructor
	public PaymentsPage(WebDriver driver) {
		super(driver);
	}

	// Web elements
	// Search and refresh table elements
	@FindBy(xpath = "//input[@placeholder='Поиск']")
	WebElement searchTableTextField;

	// Table header
	@FindBy(xpath = "//table/child::thead")
	WebElement paymentsTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement paymentsTableBody;

}
