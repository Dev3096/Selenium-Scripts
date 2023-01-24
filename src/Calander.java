import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");

		// April 23, 2023 first target getting the date and then the month

		driver.findElement(By.id("travel_date")).click();

		
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class = 'datepicker-switch']")).getText() //parent to child css
				.contains("April")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class = 'next']")).click();
			
		}

		// taking all the dates into a list
		// grab the locator which is common to all the dates (here class name )
		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equalsIgnoreCase("23")) {
				dates.get(i).click();
				break;
			}
		}

	}

}
