package components;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.*;

public class NavigationMenu extends BasePage {

	// Constructor
	public NavigationMenu(WebDriver driver) {
		super(driver);
	}

	String navigationMenuXpath = "//*[@class='sidebar-menu']";
	// Web elements

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[3]//*[contains(text(),'Сделки')]")
	WebElement deals;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[3]//li[1]//*[contains(text(), 'Новые')]")
	WebElement dealsNew;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[3]//li[3]//*[contains(text(), 'Все')]")
	WebElement dealsArchived;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[3]//li[3]//*[contains(text(), 'Все')]")
	WebElement dealsAll;

	@FindBy(xpath = "//*[@class='sidebar-menu']//child::li[8]//*[contains(text(),'Услуги')]")
	WebElement consultansy;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[4]//*[contains(text(),'Очередь')]")
	WebElement queue;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[5]//*[contains(text(),'Клиенты')]")
	WebElement clients;

	@FindBy(xpath = "//*[@class='sidebar-menu']/child::li[6]//*[contains(text(),'Менторы')]")
	WebElement mentors;

	public MentorsPage clickOnMentors() {
		mentors.click();

		return new MentorsPage(driver);

	}

	public DealsPage clickOnDeals() {
		deals.click();

		return new DealsPage(driver);
	}

	public ClientsPage clickOnClients() {
		clients.click();

		return new ClientsPage(driver);
	}

	public ConsultanciesPage clickOnConsultancy() {
		consultansy.click();

		return new ConsultanciesPage(driver);
	}

	public NavigationMenu allElementsAreVisibleAndEnabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(navigationMenuXpath)));

		assertTrue(deals.isDisplayed());
		assertTrue(consultansy.isDisplayed());
		assertTrue(queue.isDisplayed());
		assertTrue(clients.isDisplayed());
		assertTrue(mentors.isDisplayed());

		assertTrue(deals.isEnabled());
		assertTrue(consultansy.isEnabled());
		assertTrue(queue.isEnabled());
		assertTrue(clients.isEnabled());
		assertTrue(mentors.isEnabled());

		return new NavigationMenu(driver);
	}

}
