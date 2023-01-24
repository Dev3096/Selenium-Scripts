import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// //a[@value='MAA'] - chennai xpath
		// //a[@value='BLR'] - bangalore xpath
		
		//here if indexing of xpath is not used then the script would not be able to click the element from departure and arrival
		//as they have same xpaths 
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click(); //use xpath indexing when elements have same xpaths
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		
		// //div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR'] - xpath with parent - child relationship
		// //div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'] - xpath with parent - child relationship
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click(); //using patent-child relationship xpath
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(2000);
//		
//		driver.close();

	}

}
