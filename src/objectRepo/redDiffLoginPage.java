package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class redDiffLoginPage {
	
	WebDriver driver;
	public redDiffLoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	By username = By.id("login1");
	By password = By.id("password");
	By signIn = By.name("proceed");
	By home = By.xpath("//a[text() = 'rediff.com']");
	
	public WebElement EmailID() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement signUp() {
		return driver.findElement(signIn);
	}
	
	public WebElement home() {
		return driver.findElement(home);
	}

}
