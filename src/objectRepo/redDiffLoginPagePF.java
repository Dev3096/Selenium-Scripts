package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class redDiffLoginPagePF {
	
	WebDriver driver;
	public redDiffLoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	/*By username = By.id("login1");
	By password = By.id("password");
	By signIn = By.name("proceed");
	By home = By.xpath("//a[text() = 'rediff.com']");*/
	
	@FindBy(id = "login1")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(name = "proceed")
	WebElement signIn;
	
	@FindBy(xpath = "//a[text() = 'rediff.com']")
	WebElement home;
	
	public WebElement EmailID() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement signUp() {
		return signIn;
	}
	
	public WebElement home() {
		return home;
	}

}
