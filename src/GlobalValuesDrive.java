import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Eclips workspace\\Intro\\src\\Data.properties");
		prop.load(fis);                                   // set to reading mode
		System.out.println(prop.getProperty("browser")); //getting the values from the Data.properties file
		System.out.println(prop.getProperty("url"));
		prop.setProperty("browser", "firefox");           // changing the value of the browser in run time
		System.out.println(prop.getProperty("browser"));
		
		FileOutputStream fos = new FileOutputStream("D:\\Eclips workspace\\Intro\\src\\Data.properties"); // this is to modify the Data.properties file
		prop.store(fos, null); 						// set to writing mode
													// now the Data.properties file will be updated with the new value (firefox)

	}

}
