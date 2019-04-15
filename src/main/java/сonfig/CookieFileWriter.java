package сonfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieFileWriter {

	public static void writeCookiesToFile(WebDriver driver) {
		// create file named Cookies to store Login Information
		File file = new File("src/main/resources/dataProvider/Cookies.txt");
		
		try {
			// Delete old file if exists
			file.delete();
			file.createNewFile();
			
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			// loop for getting the cookie information
			for (Cookie cookie : driver.manage().getCookies()) {
				bufferedWriter.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";"
						+ cookie.getPath() + ";" + (cookie.getExpiry() == null ? 0 : cookie.getExpiry().getTime()) + ";"
						+ cookie.isSecure()));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.flush();
			bufferedWriter.close();
			fileWriter.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
