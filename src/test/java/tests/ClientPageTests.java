package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import components.NavigationMenu;
import pageObjects.ClientInfoPage;
import pageObjects.ClientsPage;
import utils.DataBase;
import utils.RandomDataGenerator;

public class ClientPageTests extends Hooks {

	static Map<String, String> clientInfoTestData = new HashMap<String, String>();
	static Map<String, String> clientInfoDataBaseData = new HashMap<String, String>();
	static Map <String,String> clientInfoUpdated  = new HashMap<String, String>();

	@Test 
	public void createClientTest() throws Exception {

		// Test data is saved to Map<String, String> clientInfoTestData;
		clientInfoTestData = RandomDataGenerator.createRandomeClientInfo();

		// Creating a new client and filling in all data about a new client

		ClientInfoPage clientInfoPage = new NavigationMenu(super.driver).allElementsAreVisibleAndEnabled().clickOnClients()
				.allElementsAreVisibleAndEnabled().clickOnCreateClientButton().allElementsAreVisibleAndEnabled()
				.createNewClientWithBlankFirstNameAndLastName().createNewClientWithBlankFirstName()
				.createNewClientWithBlankLastName()
				.createNewClient(clientInfoTestData.get("firstName"), clientInfoTestData.get("lastName"));

		ClientsPage clientsPage = clientInfoPage.allElementsAreVisibleAndEnabled()
				.fillEmailTextField(clientInfoTestData.get("email"))
				.fillCountryTextField(clientInfoTestData.get("country"))
				.fillCityTextField(clientInfoTestData.get("city"))
				.fillPhoneNumberTextField(clientInfoTestData.get("phoneNumber"))
				.fillSkypeTextField(clientInfoTestData.get("skype"))
				.fillExtraSkypeTextField(clientInfoTestData.get("extraSkype"))
				.fillExtraEmailTextField(clientInfoTestData.get("extraEmail"))

				.saveClientInfo();

		// Get data from DB
		DataBase db = new DataBase();

		String sqlStatement = "select  last_name, first_name, email, country, city, phone_number, skype\n"
				+ "from client\n" + "where last_name = " + "'" + clientInfoTestData.get("lastName") + "'"
				+ "and first_name = " + "'" + clientInfoTestData.get("firstName") + "'";

		System.out.println(sqlStatement);
		
		clientInfoDataBaseData = db.connect().getHashMapFromSQL(sqlStatement);
		db.closeConnection();
		
		System.out.println(clientInfoDataBaseData.keySet());
		System.out.println(clientInfoDataBaseData.get("last_name1"));

		clientInfoPage = clientsPage
				.searchClientByFirstAndLastName(clientInfoTestData.get("firstName"), clientInfoTestData.get("lastName"))
				.allElementsAreVisibleAndEnabled().goToClientInfoPage().allElementsAreVisibleAndEnabled();

		System.out.print("Comparing ClientInfo with UI info");

		assertEquals(clientInfoTestData.get("firstName"), clientInfoPage.getFirstNameValue());
		assertEquals(clientInfoTestData.get("lastName"), clientInfoPage.getLastNameValue());
		assertEquals(clientInfoTestData.get("email"), clientInfoPage.getEmailValue());
		assertEquals(clientInfoTestData.get("city"), clientInfoPage.getCityValue());
		assertEquals(clientInfoTestData.get("country"), clientInfoPage.getCountryValue());
		assertEquals(clientInfoTestData.get("phoneNumber"), clientInfoPage.getPhoneNumberValue());
		assertEquals(clientInfoTestData.get("skype"), clientInfoPage.getSkypeValue());
		assertEquals(clientInfoTestData.get("extraSkype"), clientInfoPage.getExtraSkypeValue());
		assertEquals(clientInfoTestData.get("extraEmail"), clientInfoPage.getExtraEmailValue());

		System.out.print("Comparing ClientInfo with DB info");

		assertEquals(clientInfoTestData.get("firstName"), clientInfoDataBaseData.get("first_name1"));
		assertEquals(clientInfoTestData.get("lastName"), clientInfoDataBaseData.get("last_name1"));
		assertEquals(clientInfoTestData.get("email"), clientInfoDataBaseData.get("email1"));
		assertEquals(clientInfoTestData.get("city"), clientInfoDataBaseData.get("city1"));
		assertEquals(clientInfoTestData.get("country"), clientInfoDataBaseData.get("country1"));
		assertEquals(clientInfoTestData.get("phoneNumber"), clientInfoDataBaseData.get("phone_number1"));
		assertEquals(clientInfoTestData.get("skype"), clientInfoDataBaseData.get("skype1"));

		// TO DO : checks for extra email and extra skype (could not find them on the client table).
	}
	
	@Test
	public void updateClientTest() throws Exception {

		// Creating a new client and filling in all data about a new client

		ClientInfoPage clientInfoPage = new NavigationMenu(super.driver).allElementsAreVisibleAndEnabled().clickOnClients()
				.allElementsAreVisibleAndEnabled()
				.searchClientByFirstAndLastName(clientInfoTestData.get("firstName"), clientInfoTestData.get("lastName"))
				.goToClientInfoPage()
				.fillFirstNameTextField("first name updated")
				.fillEmailTextField("email name updated")
				.fillCountryTextField("country updated")
				.fillCityTextField("city updated")
				.fillPhoneNumberTextField("phoneNumber updated")
				.fillSkypeTextField("skype updated")
				.fillExtraSkypeTextField("extraSkype updated")
				.fillExtraEmailTextField("extraEmail updated");
				
				clientInfoUpdated = new HashMap<String, String>();
				
				clientInfoUpdated.put("first_name", clientInfoPage.getFirstNameValue());
				clientInfoUpdated.put("last_name", clientInfoPage.getLastNameValue());
				clientInfoUpdated.put("email", clientInfoPage.getEmailValue());
				clientInfoUpdated.put("country", clientInfoPage.getCountryValue());
				clientInfoUpdated.put("city", clientInfoPage.getCityValue());
				clientInfoUpdated.put("phone_number", clientInfoPage.getPhoneNumberValue());
				clientInfoUpdated.put("skype", clientInfoPage.getSkypeValue());
				clientInfoUpdated.put("extraSkype", clientInfoPage.getExtraSkypeValue());
				clientInfoUpdated.put("extraEmail", clientInfoPage.getExtraEmailValue());
				
				
				clientInfoPage.saveClientInfo();
				
				clientInfoPage = new ClientsPage(driver)
				.allElementsAreVisibleAndEnabled()
				.searchClientByFirstAndLastName(clientInfoUpdated.get("first_name"), clientInfoUpdated.get("last_name"))
				.goToClientInfoPage();
				
				// Get data from DB
				DataBase db = new DataBase();

				String sqlStatement = "select  last_name, first_name, email, country, city, phone_number, skype\n"
						+ "from client\n" + "where last_name = " + "'" + clientInfoPage.getLastNameValue() + "'"
						+ "and first_name = " + "'" + clientInfoPage.getFirstNameValue() + "'";

				System.out.println(sqlStatement);
				
				clientInfoDataBaseData = db.connect().getHashMapFromSQL(sqlStatement);
				db.closeConnection();
				
				System.out.print("Comparing ClientInfo with UI info");

				assertEquals(clientInfoUpdated.get("first_name"), clientInfoPage.getFirstNameValue());
				assertEquals(clientInfoUpdated.get("last_name"), clientInfoPage.getLastNameValue());
				assertEquals(clientInfoUpdated.get("email"), clientInfoPage.getEmailValue());
				assertEquals(clientInfoUpdated.get("city"), clientInfoPage.getCityValue());
				assertEquals(clientInfoUpdated.get("country"), clientInfoPage.getCountryValue());
				assertEquals(clientInfoUpdated.get("phone_number"), clientInfoPage.getPhoneNumberValue());
				assertEquals(clientInfoUpdated.get("skype"), clientInfoPage.getSkypeValue());
				assertEquals(clientInfoUpdated.get("extraSkype"), clientInfoPage.getExtraSkypeValue());
				assertEquals(clientInfoUpdated.get("extraEmail"), clientInfoPage.getExtraEmailValue());

				System.out.print("Comparing ClientInfo with DB info");

				assertEquals(clientInfoUpdated.get("first_name"), clientInfoDataBaseData.get("first_name1"));
				assertEquals(clientInfoUpdated.get("last_name"), clientInfoDataBaseData.get("last_name1"));
				assertEquals(clientInfoUpdated.get("email"), clientInfoDataBaseData.get("email1"));
				assertEquals(clientInfoUpdated.get("city"), clientInfoDataBaseData.get("city1"));
				assertEquals(clientInfoUpdated.get("country"), clientInfoDataBaseData.get("country1"));
				assertEquals(clientInfoUpdated.get("phone_number"), clientInfoDataBaseData.get("phone_number1"));
				assertEquals(clientInfoUpdated.get("skype"), clientInfoDataBaseData.get("skype1"));
				

		//assertTrue(clientsPage.hasNoClientsListed());
	}

	@Test
	public void deleteCreatedClientTest() throws Exception {

		// Creating a new client and filling in all data about a new client
		System.out.print(clientInfoDataBaseData.get("first_name1"));
		System.out.print(clientInfoDataBaseData.get("last_name1"));

		ClientsPage clientsPage = new NavigationMenu(super.driver).allElementsAreVisibleAndEnabled().clickOnClients()
				.allElementsAreVisibleAndEnabled()
				.searchClientByFirstAndLastName(clientInfoDataBaseData.get("first_name1"), clientInfoDataBaseData.get("last_name1"))
				
				.allElementsAreVisibleAndEnabled().goToClientInfoPage().allElementsAreVisibleAndEnabled().deleteClient()
				.searchClientByFirstAndLastName(clientInfoDataBaseData.get("first_name1"),
						clientInfoDataBaseData.get("last_name1"));

		assertTrue(clientsPage.hasNoClientsListed());
	}
}