import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// display the first course name present on another tab

		driver.switchTo().newWindow(WindowType.TAB); // selenium will open a blank tab using this command
														// but the driver's scope is limited to the first tab only
		//driver.switchTo().newWindow(WindowType.WINDOW); //this will open a new window 
		Set<String> windows = driver.getWindowHandles(); // get all the windows and store in a Set
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("[href *= 'https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("[name = 'name']")).sendKeys(courseName);
		
		driver.quit();
	}

}
