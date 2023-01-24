import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//TestNG is one of the testing framework (provide assertions concept)

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//System.out.println(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).click(); //Select the checkbox
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected()); //to check if the checkbox is selected or not (returns boolean)
		
		//to check if the element is enabled or not
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); //this is returning true because after clicking on 'One Way' if the user clicks on 'Return Date' it gets enabled
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //pull the style attribute using getAttribute method
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) { //contains is a java method (will search of 1 in the string in this case)
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		//Count the number of checkboxes
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size(), 6);
		//System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size()); //if findElement() is used then it will find only the first checkbox and return 
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

	}

}
