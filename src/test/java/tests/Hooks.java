package tests;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import сonfig.ConfigFileReader;
import сonfig.CookieFileReader;
import сonfig.CookieFileWriter;

public class Hooks {

	public WebDriver driver;

	@Before
	public void setUp() {

		System.out.println("Hooks Before STARTS");

		ConfigFileReader configFileReader = new ConfigFileReader();

		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();

		// Delete cookies
		driver.manage().deleteAllCookies();

		driver.get(configFileReader.getBaseUrl());

		// Clear local storage
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("sessionStorage.clear();");

		try {
			driver.manage().addCookie(CookieFileReader.readCookiesFromFile());

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginWithCredentials(configFileReader.getUserName(), configFileReader.getPassword());

			CookieFileWriter.writeCookiesToFile(driver);
		}
		driver.get(configFileReader.getBaseUrl() + "/admin");

		// Dashboard page checks
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.allElementsAreVisibleAndEnabled();

		System.out.println("Before ENDS");
	}

	@After
	public void tearDown() throws InterruptedException {
		// Closing driver
		driver.quit();
	}

}
