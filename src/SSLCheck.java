import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions(); // used to set the browser behavior

		FirefoxOptions options1 = new FirefoxOptions(); // for firefox browser
		options1.setAcceptInsecureCerts(true);

		options.setAcceptInsecureCerts(true); // whenever Chrome comes across SSL certification this will accept it
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

}
