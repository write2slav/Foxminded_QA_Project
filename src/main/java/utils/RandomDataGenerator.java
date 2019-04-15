package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomDataGenerator {
	static Random random = new Random();

	public static String generateRandomText(int length) {

		String candidateChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			stringBuilder.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return stringBuilder.toString();

	}

	public static String generateRandomNumber(int range) {
		return String.valueOf(random.nextInt(range));
	}

	public static boolean generateRandomBoolean() {
		return random.nextBoolean();
	}

	public static Map<String, String> createRandomeClientInfo() {

		Map<String, String> clientInfoTestData = new HashMap<String, String>();

		clientInfoTestData.put("firstName", RandomDataGenerator.generateRandomText(15));

		clientInfoTestData.put("lastName", RandomDataGenerator.generateRandomText(15));

		clientInfoTestData.put("email",
				RandomDataGenerator.generateRandomText(15) + "@" + RandomDataGenerator.generateRandomText(15) + ".com");

		clientInfoTestData.put("country", Character.toUpperCase(RandomDataGenerator.generateRandomText(50).charAt(0))
				+ RandomDataGenerator.generateRandomText(50).substring(1));

		clientInfoTestData.put("city", Character.toUpperCase(RandomDataGenerator.generateRandomText(50).charAt(0))
				+ RandomDataGenerator.generateRandomText(50).substring(1));

		clientInfoTestData.put("phoneNumber", RandomDataGenerator.generateRandomNumber(10));

		clientInfoTestData.put("skype", RandomDataGenerator.generateRandomText(5));

		clientInfoTestData.put("extraSkype", RandomDataGenerator.generateRandomText(5));

		clientInfoTestData.put("extraEmail",
				RandomDataGenerator.generateRandomText(5) + "@" + RandomDataGenerator.generateRandomText(5) + ".com");

		return clientInfoTestData;
	}

	public static Map<String, String> createRandomeConsultancyInfo() {

		Map<String, String> consultancyTestData = new HashMap<String, String>();

		consultancyTestData.put("consultancyName", RandomDataGenerator.generateRandomText(10));

		consultancyTestData.put("consultancyDescription", RandomDataGenerator.generateRandomText(15));

		consultancyTestData.put("employeeRate", RandomDataGenerator.generateRandomNumber(10));

		consultancyTestData.put("priceUAH", RandomDataGenerator.generateRandomNumber(5));
		consultancyTestData.put("priceEUR", RandomDataGenerator.generateRandomNumber(5));
		consultancyTestData.put("priceUSD", RandomDataGenerator.generateRandomNumber(5));

		
		return consultancyTestData;
	}
}
