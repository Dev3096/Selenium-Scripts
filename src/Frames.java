import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {

		// Frames are componenents that are hosted on the webpages (a container) -
		// separatly prepared on a webpage.

		// In creating a Web site, frames is the use of multiple, independently
		// controllable sections on a Web presentation. This effect is achieved by
		// building each section as a separate HTML file and having one "master" HTML
		// file identify all of the sections.

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

		// to know how many frames are present
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		// driver.switchTo().frame(0); //switching with index (not recommended)
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // switching using webelement
		// driver.findElement(By.id("draggable")).click(); // this will give error as
		// the element is deployed in a frame

		// drag and drop concept
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		//Switching back from the iframe 
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.close();

	}

}
