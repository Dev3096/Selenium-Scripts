

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class Guru99 {
	
	static WebDriver driver; //global variable
	
	@BeforeTest
	public static void setup() {
		System.setProperty("webdriver.gecko.driver", Util.firefox);
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Util.baseURL);
	}

	@Test(dataProvider="getData")
	public void loginVerification(String username, String password) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		int count = 0;
		List<String> temp = Util.excelParametrization();
//		for (int i = 0; i < temp.size(); i = i + 2) {
			count = count + 1;
//			String username = temp.get(i);
//			String password = temp.get(i+1);
			
			driver.findElement(By.name("uid")).sendKeys(username);
			
			Thread.sleep(2000);
			driver.findElement(By.name("password")).sendKeys(password);
			
			Thread.sleep(2000);
			driver.findElement(By.name("btnLogin")).click();
			
			Thread.sleep(2000);
			
			try {
				Alert alt = driver.switchTo().alert();
				String actualBoxtitle = alt.getText(); // get content of the Alter Message
				alt.accept();
				if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
				    System.out.println("Test case SS[" + count + "]: Passed"); 
				} else {
				    System.out.println("Test case SS[" + count + "]: Failed");
				}
			}
			catch (NoAlertPresentException Ex) {
				String actualTitle = driver.getTitle();
				// On Successful login compare Actual Page Title with Expected Title
				if (actualTitle.contains(Util.expectedTitle)) {
				    System.out.println("Test case SS[" + count + "]: Passed");
				} else {
				    System.out.println("Test case SS[" + count + "]: Failed");
				}
				// verify manager id
				String managerID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
				System.out.println(managerID);
				if (managerID.contains(username)) {
					System.out.println("ManagerID verified");
				} else {
					System.out.println("Incorrect ManagerID");
				}
				
				//Screenshot
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // casting the driver object to
																						// TakesScreenShot object
																						// OutputType.FILE output is obtained as
																						// a file and stored in src object
				FileUtils.copyFile(src, new File(Util.screenShot_path)); // method to copy the source object to our
																			// local
																			// machine
				// to get the screenshot in the C drive requires
				// admin rights( hence would give an error)
				//logout
				driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
				driver.switchTo().alert().accept();
			}
			//driver.close();
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[4][2];
		data[0][0] = "mngr464068"; //0th row 0th column and so on..
		data[0][1] = "AvAzyhA";
		
		data[1][0] = "dsfdsfd";
		data[1][1] = "AvAzyhA";
		
		data[2][0] = "mngr464068";
		data [2][1] = "svsdv";
		
		data[3][0] = "sdvsdv";
		data[3][1] = "dsvsv";
		return data;
		
	}
}
