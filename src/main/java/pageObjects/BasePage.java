package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import сonfig.ConfigFileReader;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public ConfigFileReader configFileReader;

	// Constructor
	public BasePage(WebDriver driver) {
		this.configFileReader = new ConfigFileReader();

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);

		PageFactory.initElements(driver, this);
	}

	// Common methods
	
}
