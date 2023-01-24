import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String myCountry = "India";

		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		Boolean element = true;
		List<WebElement> country = driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] div"));

		for (int i = 0; i < country.size(); i++) {
			if (country.get(i).getText().equals(myCountry)) {
				country.get(i).click();
				break;
			} else {
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			}
		}

		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); // to get the value from an
																								// input box
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), myCountry);

	}

}
