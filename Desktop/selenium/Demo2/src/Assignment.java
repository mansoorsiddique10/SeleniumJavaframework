import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException, IOException {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
		

		
		driver.findElement(By.xpath("//*[@id=\"AccountCustomer_ul\"]/li[4]/a")).click();
		
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"body_cph_MyAccount_ddlAccountNo\"]"));
		Thread.sleep(3000);
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("body_cph_MyAccount_rblTransactions_0")).click();
		
		driver.findElement(By.xpath("//*[@id=\"body_cph_MyAccount_btnViewTrancastions\"]")).click();
		
		/*
		 * File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * FileUtils.copyFile(SrcFile, new File("C:\\Chromedriver104\\ image2.jpeg"));
		 */
		
		//*[@id="body_cph_MyAccount_gvTransaction"]
		//*[@id="tblGrid"]/tbody/tr[2]/td
		
		
		//*[@id="tblGrid"]
		//*[@id="tblGrid"]/tbody/tr[2]/td
		
		WebElement table = driver.findElement(By.xpath("//*[@id=\"body_cph_MyAccount_gvTransaction\"]/tbody/tr[2]"));  //*[@id="body_cph_MyAccount_gvTransaction"]/tbody/tr[2]
		
		List<WebElement> col = table.findElements(By.tagName("TD"));
		String[] colelement = new String[5];
		int i = 0;
		for(WebElement x:col) {
			colelement[i] = x.getText();
			
		}
		
		Row row = sheet.createRow(1);
		
		
		
		
		
		
		
		/*
		 * for(String x:colelement) { System.out.println(); }
		 */
		/*
		 * for(int row=0;row<totalRows.size();row++) { List<WebElement> totalColumns =
		 * totalRows.get(row).findElements(By.tagName("TD"));
		 * 
		 * for(int col=0;col<totalColumns.size();col++) { String cellValue =
		 * totalColumns.get(col).getText();
		 * 
		 * System.out.print(cellValue+"\t"); } System.out.println(); }
		 */
		 
		
		//driver.findElement(By.id("lbLoginOut")).click();
	}

}
