package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepo.redDiffLoginPage;
import objectRepo.redDiffLoginPagePF;
import objectRepo.rediffHome;
import objectRepo.rediffHomePF;

public class LoginApplication {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		redDiffLoginPagePF login = new redDiffLoginPagePF(driver); //object for login page 
		rediffHomePF home = new rediffHomePF(driver); // object for home page
		
		login.EmailID().sendKeys("dev@gmail.com");
		login.password().sendKeys("password");
		login.signUp().click();
		login.home().click();
		
		home.search().sendKeys("rediff");
		Thread.sleep(2000);
		home.submit().click();
		
		
	}

}
