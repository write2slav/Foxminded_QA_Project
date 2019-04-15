package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QueuePage extends BasePage {

	public QueuePage(WebDriver driver) {
		super(driver);

	}

	// Web elements
	// Tabs: Group Development, Mentoring, Personal mentor
	@FindBy(xpath = "//ul[@class= 'nav nav-tabs']/child::li[1]")
	WebElement groupDevelopmentTab;

	@FindBy(xpath = "//ul[@class= 'nav nav-tabs']/child::li[2]")
	WebElement mentoringTab;

	@FindBy(xpath = "//ul[@class= 'nav nav-tabs']/child::li[3]")
	WebElement personalMentorTab;

	// Search and refresh table elements
	@FindBy(xpath = "//input[@placeholder='Поиск']")
	WebElement searchTableTextField;

	@FindBy(xpath = "//button[@title='Обновить']")
	WebElement refreshTableBtn;

	// Group development table elements

	@FindBy(xpath = "//*[@id='tab-3']/descendant::table[@class='table table-hover']/child::thead")
	WebElement groupDevelopmentTableHead;

	@FindBy(xpath = "//*[@id='tab-3']/descendant::table[@class='table table-hover']/child::tbody")
	WebElement groupDevelopmentTableBody;

	// Mentoring table locators
	@FindBy(xpath = "//*[@id='tab-1']/descendant::table[@class='table table-hover']/child::thead")
	WebElement mentoringTableHead;

	@FindBy(xpath = "//*[@id='tab-1']/descendant::table[@class='table table-hover']/child::tbody")
	WebElement mentoringTableBody;

	// Personal mentor table locator
	@FindBy(xpath = "//*[@id='tab-2']/descendant::table[@class='table table-hover']/child::thead")
	WebElement personalMentorTableHead;

	@FindBy(xpath = "//*[@id='tab-2']/descendant::table[@class='table table-hover']/child::tbody")
	WebElement personalMentorTableBody;

	public void getTable() {
		// TODO Auto-generated method stub
		System.out.println("Table");
		System.out.println(groupDevelopmentTableHead.getText());

	}

}
