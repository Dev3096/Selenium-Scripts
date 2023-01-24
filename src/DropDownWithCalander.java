import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithCalander {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		Thread.sleep(2000);
		
		//.css-76zvg2.r-jwli3a.r-xb2eav.r-majxgm.r-q4m81j
		driver.findElement(By.cssSelector("div[data-testid = 'search-source-code']")).click();
		
		driver.findElement(By.xpath("//div[text() = 'BLR - Bengaluru, India']")).click(); //use xpath indexing when elements have same xpaths
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div[data-testid = 'search-destination-code']")).click();
		
		driver.findElement(By.xpath("(//div[text() = 'Chhatrapati Shivaji International Airport'])[2]")).click();
		
		driver.findElement(By.cssSelector(".ui-datepicker-unselectable.ui-state-disabled.ui-datepicker-today")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		

	}

}
