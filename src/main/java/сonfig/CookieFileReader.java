package сonfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.Cookie;

public class CookieFileReader {

	public static Cookie readCookiesFromFile() throws FileNotFoundException, IOException {

		Cookie cookie;

		BufferedReader bufferReader = new BufferedReader(new FileReader("src/main/resources/dataProvider/Cookies.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = bufferReader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferReader.readLine();
			}
			String cookieString = sb.toString();
			String[] cookeisArray = cookieString.split(";");
			String name = cookeisArray[0];
			String value = cookeisArray[1];
			String domain = cookeisArray[2];
			String path = cookeisArray[3];
			// Setting 20 day for expiry date
			Date expiry = new Date(new Date().getTime() + (1000 * 3600 * 24 * 20));
			System.out.print(expiry);
			Boolean isSecure = Boolean.valueOf(cookeisArray[5]);

			cookie = new Cookie(name, value, domain, path, expiry, isSecure);

		} finally {
			bufferReader.close();
		}
		return cookie;
	}
}