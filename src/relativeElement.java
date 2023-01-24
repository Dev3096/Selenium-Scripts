import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativeElement {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name = driver.findElement(By.cssSelector("[name = 'name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText()); //above relative locator
		
		WebElement date = driver.findElement(By.cssSelector("[for = 'dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(date)).click();                   //below relative locator
		
		WebElement check = driver.findElement(By.cssSelector("[for = 'exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(check)).click();				//left of check box
		
		WebElement right = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(right)).getText());   // right of check box

	}

}
