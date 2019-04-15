package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import components.NavigationMenu;
import pageObjects.ConsultanciesPage;
import pageObjects.ConsultancyInfoPage;
import utils.RandomDataGenerator;

public class ConsultancyPageTests extends Hooks {

	static Map<String, String> consultancyTestData = new HashMap<String, String>();

	@Test
	public void createNewConsultancy() throws InterruptedException {

		// Test data is saved to Map<String, String>
		consultancyTestData = RandomDataGenerator.createRandomeConsultancyInfo();

		// Click on consultancy item in navigation menu
		NavigationMenu navigationMenu = new NavigationMenu(super.driver);

		ConsultanciesPage consultanciesPage = navigationMenu.allElementsAreVisibleAndEnabled().clickOnConsultancy()
				.allElementsAreVisibleAndEnabled().clickOnCreateConsultancyButton().createNewConsultancy(
						consultancyTestData.get("consultancyName"), consultancyTestData.get("consultancyDescription"),
						consultancyTestData.get("priceUAH"), consultancyTestData.get("priceUSD"),
						consultancyTestData.get("priceEUR"), consultancyTestData.get("employeeRate"));

		ConsultancyInfoPage consultancyInfoPage = consultanciesPage.allElementsAreVisibleAndEnabled()
				.searchConsultancyBy(consultancyTestData.get("consultancyName")).goToConsultancyInfoPage();

		assertEquals(consultancyTestData.get("consultancyName"), consultancyInfoPage.getName());
		assertEquals(consultancyTestData.get("consultancyDescription"), consultancyInfoPage.getDescription());
		assertEquals(consultancyTestData.get("employeeRate"), consultancyInfoPage.getEmployeeRateAmount());
		assertEquals(consultancyTestData.get("priceUAH"), consultancyInfoPage.getPriceUah());
		assertEquals(consultancyTestData.get("priceEUR"), consultancyInfoPage.getPriceEur());
		assertEquals(consultancyTestData.get("priceUSD"), consultancyInfoPage.getPriceUsd());

	}

	@Test
	public void deleteConsultancy() throws InterruptedException {

		PageFactory.initElements(driver, NavigationMenu.class).clickOnConsultancy().allElementsAreVisibleAndEnabled()
				.searchConsultancyBy(consultancyTestData.get("consultancyName")).goToConsultancyInfoPage()
				.allElementsAreVisibleAndEnabled().deleteConsultancy().allElementsAreVisibleAndEnabled()
				.searchConsultancyBy(consultancyTestData.get("consultancyName"));

		assertTrue(PageFactory.initElements(driver, ConsultanciesPage.class).hasNoConsultanciesListed());

	}

}
