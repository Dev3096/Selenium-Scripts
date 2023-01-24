import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Broken links means that the page is showing error (broken URL)
		// make sure all the url and check their status code
		// Java methods will call URL's and gets the status code

		// Step 1 : to get all URL's tied up to the links using selenium
		// if status code is > 400 is not working -> hence links which is tied to this
		// URL is broken

		// String url = driver.findElement(By.cssSelector("a[href *=
		// 'broken']")).getAttribute("href"); // this will give
		// the link of
		// soapUI (used
		// getAttribute
		// method)

		List<WebElement> links = driver.findElements(By.cssSelector(".gf-t a"));
		SoftAssert a = new SoftAssert();

		for (int i = 0; i < links.size(); i++) {
			String url = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); // openConnection is present in
																						// URL class its return type is
																						// HttpURLConnection
			conn.setRequestMethod("HEAD"); // making a call using HEAD method
			conn.connect(); // will get a response back // will be used to get the status code
			int response = conn.getResponseCode();
//			if (response > 400) {
//				System.out.println(links.get(i).getText());
//				Assert.assertTrue(false); // but here we were not able to check all the links as the script stopped on the first
//											// broken link - to solve this soft assertions(given by TestNG) are used
//			}
			a.assertTrue(response < 400, links.get(i).getText()); // soft assertion (if the condition is not met then
																	// the message is displayed)
																	// it will not break the script but will give a
																	// message whenever the condition is not met

		}
		a.assertAll(); // this will report all the assertion results (must be added in the end if soft
						// assertion is used)

	}

}
