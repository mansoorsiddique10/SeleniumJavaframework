import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_13_parameterization {
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void test() throws IOException, InterruptedException {
		String FilePath ="C:\\Users\\mansoor.hussain\\Downloads\\IVSIS_Cred_26May17_1802.xlsx";
		FileInputStream fileStream = new FileInputStream(FilePath);
		XSSFWorkbook book = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = book.getSheet("Credentials");
		
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=1; i<=rowCount; i++)
		{
			String userName = sheet.getRow(i).getCell(0).getStringCellValue();
			
		System.out.println(userName);
		
		
		String password = sheet.getRow(i).getCell(1).getStringCellValue();
	
		System.out.println(password);
				
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).clear();
		
		
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys(userName);
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//*[@id=\"body_txtPassword\"]")).sendKeys(password);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"body_btnLogin\"]")).click();
		
		Thread.sleep(3000);
		
		
		String validMessage = driver.findElement(By.id("divWelcome")).getText();
		
		
		
		List<WebElement> message = driver.findElements(By.id("body_lblStatus"));
		
		Row row = sheet.getRow(i);
		
		Cell cell = row.createCell(2);
		
		
		if(message.size()== 0)
			
		{	Thread.sleep(3000);
			cell.setCellValue(validMessage);
		
		
			driver.findElement(By.xpath("//*[@id=\"lbLoginOut\"]")).click();
		}
		else {
			
			String errorMessage = driver.findElement(By.id("body_lblStatus")).getText();
			cell.setCellValue(errorMessage);
			continue;
					
		}
		
		
		FileOutputStream out = new FileOutputStream(FilePath);
		book.write(out);
		
	}
		book.close();

}
}
