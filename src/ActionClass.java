import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {

	public static void main(String[] args) {

		// Actions:
		// 1. How to MouseHover on object with Selenium
		// 2. Performing Mouse and Keyboard interactions with Selenium (eg Writing
		// something in CAPS)
		// 3. Context click on element (right click )
		// 4. Double click on element
		// 5. Drag and Drop the element

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.amazon.com/");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));

		Actions a = new Actions(driver);
		// Writing in CAPS
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("hello kitty").build().perform();
		
		//double click on the text to select it
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().build().perform();

		// Hovers to specific element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform(); // .build means that this
																								// step is ready to
																								// execute and .p means
																								// to execute this
																								// action
		//performing right click
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
	}

}
