import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfIntro {

	public static void main(String[] args) {
		
		//Invoking the Browser
		//Chrome - ChromeDriver(Class) -> Methods
		//webdriver methods + personal class methods
		//chromedriver.exe -> invoke chrome browser 
		//webdriver.chrome.driver -> give browser path
		
		//Chrome Launch
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//FireFox launch
		//System.setProperty("webdriver.gecko.driver", "D:/Eclips workspace/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//Edge launch
		//System.setProperty("webdriver.edge.driver", "D:/Eclips workspace/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		
		//driver.close();
		

	}

}
