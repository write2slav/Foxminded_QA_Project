package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoneyFlowPage extends BasePage {

	// Constructor
	public MoneyFlowPage(WebDriver driver) {
		super(driver);
	}

	// Web elements

	@FindBy(xpath = "//*[@id=\"selectedConsultancyField\"]")
	WebElement consultancyTextField;

	@FindBy(xpath = "//*[@id=\"beginDateField\"]")
	WebElement beginDateTextField;

	@FindBy(xpath = "//*[@id=\"endDateField\"]")
	WebElement endDateTextField;

	@FindBy(xpath = "//form[@name='requestParameters']/descendant::button[contains(text(),'Make report')]")
	WebElement makeReportBtn;

}
