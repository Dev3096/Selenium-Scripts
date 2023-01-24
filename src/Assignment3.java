import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class = 'checkmark'])[2]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
		driver.findElement(By.id("okayBtn")).click();
	//	driver.findElement(By.xpath("//select[@class = 'form-control']")).click();
		
		WebElement drop = driver.findElement(By.xpath("//select[@class = 'form-control']"));
		Select dropdown = new Select(drop);
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
		
		List<WebElement> phones = driver.findElements(By.cssSelector(".btn.btn-info"));
		for (int i = 0; i < phones.size(); i++) {
			phones.get(i).click();
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

	}

}
