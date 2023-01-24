import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {

		// Implicit Wait:
		// 1. Define a wait time globally. eg wait for n number of seconds before
		// throwing exception
		// 2. It is applicable for the entire script
		// 3. It will not wait for exactly n seconds. Once the web element is available
		// the script will proceed with the execution
		// 4. What if the site takes 15 seconds to load (A big disadvantage ) - test
		// execution will become very slow

		// Explicit Wait: (Consists of WebDriverWait and FluentWait classes)
		// Only targets specific element (Apply specific wait for some targeted web
		// element)

		// Thread.sleep()
		// Holding the script for n seconds. Will wait for n seconds even if the web
		// element is present

		// Fluent wait
		// 1. Fluent wait finds the web element repeatedly at regular intervals of time
		// until the timeout or till the object is found
		// 2. Key difference between WebDriverWait and FluentWait is that if thee wait
		// is for 5 sec, WebDriverWait keeps on monitoring continuously the DOM until
		// timeout or till the object is found. FluentWait monitors the DOM at regular
		// intervals (defined by polling time).
		// 3. WebDriverWait uses built in wait methods whereas in FluentWait customized
		// wait methods based on conditions need to be built.

		// Syntaxes
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); Implicit wait

		// WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		// w.until(ExpectedConditions.visibilityOfElementLocated('Enter Locator here'));
		// --Explicit wait

	}

}
