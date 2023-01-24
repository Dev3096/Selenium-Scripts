import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("name")).sendKeys("Devansh");
		driver.findElement(By.name("email")).sendKeys("dev30@gmail.com");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("123456789");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement staticDrop = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDrop);
		dropdown.selectByIndex(0);
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[type = 'date']")).sendKeys("12-12-1998");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		Thread.sleep(2000);
		driver.close();
		

	}

}
