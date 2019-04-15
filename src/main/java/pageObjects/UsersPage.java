package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

	// Constructor
	public UsersPage(WebDriver driver) {
		super(driver);
	}

	// Web elements

	@FindBy(xpath = "//*[@id='fixed-table-toolbar--buttons']/button[@data-target='#addNewModal' and contains(text(), 'Add new User')]")
	WebElement addNewUserBtn;

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