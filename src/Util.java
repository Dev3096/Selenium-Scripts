import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {

	public static final String firefox =  "D:/Eclips workspace/Grid/geckodriver.exe";
	public static final String baseURL = "https://www.demo.guru99.com/V4/";
	public static final String expectedTitle = "Guru99 Bank Manager HomePage";
	public static final String EXPECT_ERROR = "User or Password is not valid";
	public static final String exel_location = "D:\\Eclips workspace\\Intro\\src\\Guru99.xlsx";
	public static final String screenShot_path = "D:\\\\Eclips workspace\\\\Intro\\\\src\\\\screenshot.png";
	
	public static List<String> excelParametrization() throws IOException {
		List<String> temp = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(exel_location);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // this accepts a fileInputStream argument
		int sheets = workbook.getNumberOfSheets(); // total amount of sheets present in the document
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("login")) { // scans all the sheets and if the sheet name
																			// is "login" the sheet is stored in
																			// sheet object
				XSSFSheet sheet = workbook.getSheetAt(i);
				// identify logins column by scanning the entire 1st row
				Iterator<Row> rows = sheet.rowIterator();
				Row first = rows.next(); // the control will be at the first row
				Iterator<Cell> ce = first.cellIterator();
				int k = 0; // to get the index
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					k++;
				}
				//System.out.println(k);
				while (rows.hasNext()) {
					Row r = rows.next();
					Iterator<Cell> cv = r.cellIterator();
					while (cv.hasNext()) {
					Cell c = cv.next();
					temp.add(c.getStringCellValue().toString());
					
					}
				}
			}
		}
		return temp;
	}
}
	


