import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();//if there is space between 2 elements of class name then it means that there are 2 classes associated
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait (This wait would be applied for each and every step) waiting for objects to show on the page
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());//add implicit wait 
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Devansh");
		
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("devgoel@gmail.com");
		
		driver.findElement(By.xpath("//input[@type=\"text\"][2]")).clear(); //to clear the text (used xpath with indexing)
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("devgoel30@gmail.com"); //used css with indexing
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9087654635"); //used xpath with parent and child tag name with indexing
		
		Thread.sleep(1000); //wait for 1 second
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		String password = getPassword(driver);
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); //used xpath with attributes and indexing
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("devansh"); //used css selector with ID
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password); //used css selector with regular expression
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //using xpath with regular expression
		
		Thread.sleep(1000);
		
		//driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		String passVar = driver.findElement(By.cssSelector("form p")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] paswordArray = passVar.split("'");
		//0th index - Please use temporary password
		//1st index = rahulshettyacademy' to Login.
		
		String password = paswordArray[1].split("'")[0];
		//0th index - rahulshettyacademy
		//1st index -  to Login.
		
		return password;
		
		
		
		
	}

}
