package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import components.CreateEmployeePopUp;

public class MentorsPage extends BasePage {

	public MentorsPage(WebDriver driver) {
		super(driver);
		assertEquals(super.configFileReader.getBaseUrl() + "admin/employees", driver.getCurrentUrl());

	}

	// Web elements

	// Create employee button
	@FindBy(xpath = "//*[@id='fixed-table-toolbar--buttons']/button[contains(text(), 'Create')]")
	@CacheLookup
	WebElement createEmployeeBtn;

	// Search and refresh button
	@FindBy(xpath = "//*[@class='pull-right search']/child::input[@placeholder='Поиск']")
	@CacheLookup
	WebElement searchTableTextField;

	// Refresh button
	@FindBy(xpath = "//*[@class='columns columns-right btn-group pull-right']/child::button[@title='Обновить']")
	@CacheLookup
	WebElement refreshTableBtn;

	// Table header
	@FindBy(xpath = "//table/child::thead")
	@CacheLookup
	WebElement mentorsTableHeader;

	// Table body
	@FindBy(xpath = "//table[@class='table table-hover']/child::tbody")
	WebElement mentorsTableBody;

	// Number of records listed below the table
	@FindBy(xpath = "//*[ starts-with(text(),'Записи с 1 по')]")
	WebElement numberOfRecordsInTable;

	//
	// Page methods

	// Get all the names cells in the table
	public List<WebElement> getNameColumn() {

		List<WebElement> columnCells = mentorsTableBody.findElements(By.xpath(".//td[1]"));

		for (WebElement cell : columnCells) {
			System.out.println(cell.getText());
		}

		return columnCells;
	}

	// Get all the workloads cells in the table
	public List<WebElement> getWorkloadColumn() {

		List<WebElement> columnCells = mentorsTableBody.findElements(By.xpath(".//td[2]"));

		System.out.println(columnCells.size());

		for (WebElement cell : columnCells) {
			System.out.println(cell.getText());
		}

		return columnCells;
	}

	// Get number of records listed in the the table(located under the table)
	public int getNumberOfRecordsInTheTable() {

		String numberOfRecords = numberOfRecordsInTable.getText();
		System.out.println(numberOfRecords);

		return Character.getNumericValue(numberOfRecords.charAt(numberOfRecords.length() - 1));
	}

	public CreateEmployeePopUp clickOnCreateEmployeeBtn() {
		wait.until(ExpectedConditions.visibilityOf(createEmployeeBtn));
		createEmployeeBtn.click();

		return PageFactory.initElements(driver, CreateEmployeePopUp.class);
	}

	public MentorsPage allElementsAreVisibleAndEnabled() {

		wait.until(ExpectedConditions.visibilityOf(createEmployeeBtn));

		assertTrue(createEmployeeBtn.isDisplayed());
		assertTrue(searchTableTextField.isDisplayed());
		assertTrue(refreshTableBtn.isDisplayed());

		assertTrue(createEmployeeBtn.isEnabled());
		assertTrue(searchTableTextField.isEnabled());
		assertTrue(refreshTableBtn.isEnabled());

		return PageFactory.initElements(driver, MentorsPage.class);
	}

}
