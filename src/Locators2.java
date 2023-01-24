import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "dev";
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait (This wait would be applied for each and every step) waiting for objects to show on the page
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();//if there is space between 2 elements of class name then it means that there are 2 classes associated
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in."); // compare actual with expected (this assertions comes from testNg)
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); //used xpath with text() (only applicable with xpath not with css)
		
		Thread.sleep(2000);
		
		driver.close();
		

	}

}
