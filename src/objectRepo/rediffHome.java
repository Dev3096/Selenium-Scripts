package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rediffHome {

	WebDriver driver;

	public rediffHome(WebDriver driver) {
		this.driver = driver;
		}
	
	By search = By.id("srchword");
	By submit = By.xpath("(//input[@type = 'submit'])[1]");
	
	public WebElement search() {
		return driver.findElement(search);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	

}
