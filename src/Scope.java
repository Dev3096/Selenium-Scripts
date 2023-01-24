import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 1. Count the links on this page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. Get the count of links present only in the footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size()); // this is called
																			// limiting
																			// webdriver
																			// scope
		// 3. Links count of only first column in the footer section
		WebElement firstcolumn = driver.findElement(By.id("gf-BIG"))
				.findElement(By.xpath("//div[@id = 'gf-BIG']/table/tbody/tr/td[1]"));
		System.out.println(firstcolumn.findElements(By.tagName("a")).size());

		// 4. Click on each link in the column and check if the pages are opening.
		// approach here is to open all the links in seperate tabs and then get the
		// title of all the tabs
		for (int i = 1; i < firstcolumn.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER); // Selects control and then clicks on the links
																		// to open them in another tab

			firstcolumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink); // passing clickOnLink to open them
																					// in seperate tabs

		}

		// iterating over all the window handles to get the title
//		int j = 0;
//		Set<String> handles = driver.getWindowHandles();
//		Iterator<String> it = handles.iterator();
//		while (j < handles.size()) {
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//			j++;
//		}

		// another way to write while loop (above is also valid but uses an extra
		// variable j)
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
