import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1. Select any checkbox and then grab the lable (text) of the selected
		// checkbox
		driver.findElement(By.id("checkBoxOption2")).click();
		String myOption2 = driver.findElement(By.xpath("//label[@for = 'benz']")).getText();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText(myOption2);
		
		driver.findElement(By.id("name")).sendKeys(myOption2);
		driver.findElement(By.id("alertbtn")).click();
		
		String myText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1].trim();
		//System.out.println(myText);
		Assert.assertEquals(myOption2, myText);
		
		System.out.println("Test Passed");
	}

}
