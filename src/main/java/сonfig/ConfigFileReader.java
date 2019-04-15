package сonfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

 public class ConfigFileReader {

	private Properties properties;

	private String propertyFilePath = "src/main/resources/dataProvider/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getBaseUrl() {
		String url = properties.getProperty("baseUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("chromeDriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getUserName() {
		String userName = properties.getProperty("userName");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public void write() {
		properties.setProperty("password","lalala");

	}

}
