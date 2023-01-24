import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on the column to sort
		// capture all the column values into a list using getText (Original List)
		// apply sort and prepare a new list -> sorted list
		// compare original list with the sorted list

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> veg = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> textVeg = veg.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedVeg = textVeg.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(textVeg.equals(sortedVeg));
		
		List<String> price;
		// get the price for each vegetable
		// scan the name column with getText and if we get the required name then print
		// the price that vegetable (Beans here)
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a)); // print all the list elements
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label = 'Next']")).click();
			}
		} while (price.size() < 1);
		

	}

	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

}
