package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryCalculationPage extends BasePage {

	// Constructor
	public SalaryCalculationPage(WebDriver driver) {
		super(driver);
	}

	// Web elements

	@FindBy(xpath = "//*[@id='payroll-form']/descendant::input[@name='dateFrom']")
	WebElement dateFromTextField;

	@FindBy(xpath = "//*[@id='payroll-form']/descendant::input[@name='dateTo']")
	WebElement dateToTextField;

	@FindBy(xpath = "//*[@id='payroll-form']/descendant::button[@type='submit' and contains(text(), 'Calculate salaries') ]")
	WebElement calculateSalariesBtn;
}
