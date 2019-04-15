package tests;

import org.junit.Test;

import components.NavigationMenu;

public class MentorsPageTests extends Hooks {
	@Test
	public void createEmployeeTest() {

		// Click on Clients item in navigation menu
		NavigationMenu navigationMenu = new NavigationMenu(super.driver);

		// Click on create Employee button in mentors page
		navigationMenu.clickOnMentors()
						.allElementsAreVisibleAndEnabled()
							.clickOnCreateEmployeeBtn()
								.allElementsAreVisibleAndEnabled()
								.createNewEmpoloyeeWithEmptyFields()
								.createNewEmpoloyeeWithEmptyLastNameField()
								.createNewEmpoloyeeWithEmptyFirstNameField()
								.createNewEmpoloyeeWithEmptyMaxLoadField()
									.createNewEmpoloyee("TestFirstName", "TestLastName", "5");

	}

}
