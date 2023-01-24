import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEnd {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click(); //use xpath indexing when elements have same xpaths
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) { //contains is a java method (will search of 1 in the string in this case)
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		WebElement staticDrop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //this is done to store the dropdown web location in  a variable
		Select dropdown = new Select(staticDrop);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText()); // dropdown.getFirstSelectedOption() this will return the web element of the option selected 
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
