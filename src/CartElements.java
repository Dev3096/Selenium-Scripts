import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartElements {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		// Advantage of implicit wait
		// 1. Readable code
		// 2. Applied to each and every step (Globally)

		// Disadvantage
		// 1. Implicit wait hides the performance issue for the site. (if an element is
		// required to take lesser amount of time for loading implicit wait will hide
		// this bug as the script will wait for the amount to implicit time defined by
		// the user
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		Thread.sleep(3000);
		// expected elements array
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Brinjal", "Tomato" }; // new object will be created if we add
																				// elements (immutable)
		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		
		//Explicit wait
		//Advantages of Explicit wait
		//1. Applied only when required and only at targeted elements 
		
		//Disadvantage
		//1. More lines of code
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List li = Arrays.asList(itemsNeeded); // converted array to arrayList

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText().split("-")[0].trim();
			// System.out.println(products.get(i).getText().split("-")[0].trim());
			// format it to get the actual vegetable name
			// check name present in the array itemsNeeded is present or not
			// first convert array to arrayList as assarList supports a method called
			// contains (for easy search)
			int count = 0;
			if (li.contains(name)) {

				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click(); // first
																											// getting
																											// the
				// index and then
				// clicking
				// always choose a static xpath as above.
				count++;
			}
			if (count == li.size()) { // we use length() method to get size of Array and size() method to get size of
										// ArrayList
				break;
			}
		}
	}

}
