import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class SceenShot {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:/Eclips workspace/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // casting the driver object to
																				// TakesScreenShot object
																				// OutputType.FILE output is obtained as
																				// a file and stored in src object
		FileUtils.copyFile(src, new File("D://screenshot.png")); // method to copy the source object to our local
																	// machine
																	// to get the screenshot in the C drive requires
																	// admin rights( hence would give an error)
		
		

	}

}
