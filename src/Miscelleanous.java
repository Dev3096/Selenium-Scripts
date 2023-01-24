import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the window
		
		//to delete all cookies
		driver.manage().deleteAllCookies();
		
		//to delete a cookie with a name
		driver.manage().deleteCookieNamed("name of the cookee");
		
		// the above functionality can be used to delete session key scenario
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		

	}

}
