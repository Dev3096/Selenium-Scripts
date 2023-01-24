import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //to maximize the browser
		
		driver.get("http://google.com");
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); //navigate from one link to another
		
		//difference between get and navigate:-
		//for driver.get selenium will pause until the page is fully loaded
		//for driver.navigate selenium will continue with the next steps irrespective of weather the page is loaded or not
		
		driver.navigate().back(); //this will take back to the google.com page
		
		driver.navigate().forward(); //this will navigate back to rahulshetty.cam/AutomationPractice/ page
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
