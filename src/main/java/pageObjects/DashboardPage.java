package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

	// Constructor
	public DashboardPage(WebDriver driver) {
		super(driver);
		// Validating page title
		assertEquals("Admin panel", driver.getTitle());
	}

	// Page web elements

	@FindBy(id = "activeStudentCount")
	WebElement activeStudentsCount;

	@FindBy(id = "newStudentsCount")
	WebElement newstudentsCount;

	@FindBy(id = "frozenStudentsCount")
	WebElement frozenStudentsLocatorCount;

	@FindBy(id = "graduatedStudentsCount")
	WebElement graduatedStudentsCount;

	@FindBy(xpath = "//div[@class='box box-info']//button[@data-widget='collapse']")
	WebElement collapseTableBtn;

	@FindBy(xpath = "//div[@class='box box-info']//button[@data-widget='remove']")
	WebElement closeTableBtn;

	@FindBy(xpath = "//*[@id='consultancyStaticticsTbody']")
	WebElement consultancyTableBody;

	public DashboardPage allElementsAreVisibleAndEnabled() {

		wait.until(ExpectedConditions.visibilityOf(consultancyTableBody));

		assertTrue(consultancyTableBody.isDisplayed());

		assertTrue(activeStudentsCount.isDisplayed());
		assertTrue(newstudentsCount.isDisplayed());
		assertTrue(frozenStudentsLocatorCount.isDisplayed());
		assertTrue(graduatedStudentsCount.isDisplayed());

		assertTrue(collapseTableBtn.isEnabled());
		assertTrue(closeTableBtn.isEnabled());

		return PageFactory.initElements(driver, DashboardPage.class);
	}

	public String getConsultancyNameAtRow(int row) {

		return consultancyTableBody.findElement(By.xpath("./child::tr[" + String.valueOf(row) + "]/child::td[1]"))
				.getText();
	}

	public String getConsultancyActiveCasesNumberAtRow(int row) {

		return consultancyTableBody.findElement(By.xpath("./child::tr[" + String.valueOf(row) + "]/child::td[2]"))
				.getText();
	}

	public String getConsultancyCompletedCasesNumberAtRow(int row) {

		return consultancyTableBody.findElement(By.xpath("./child::tr[" + String.valueOf(row) + "]/child::td[3]"))
				.getText();
	}

	public String getConsultancyFrozenCasesNumberAtRow(int row) {

		return consultancyTableBody.findElement(By.xpath("./child::tr[" + String.valueOf(row) + "]/child::td[4]"))
				.getText();
	}

	public int getActiveStudentsNumber() {

		return Integer.valueOf(activeStudentsCount.getText());
	}

	public int getNewStudentsNumber() {

		return Integer.valueOf(newstudentsCount.getText());
	}

	public int getFrozenStudentsNumber() {

		return Integer.valueOf(frozenStudentsLocatorCount.getText());
	}

	public int getGraduatedStudentsNumber() {

		return Integer.valueOf(graduatedStudentsCount.getText());
	}

}
