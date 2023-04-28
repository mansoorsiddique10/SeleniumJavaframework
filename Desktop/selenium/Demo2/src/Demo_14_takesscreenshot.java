import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_14_takesscreenshot {
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
		
		driver.close();
	}

	@Test
	public void test() throws IOException {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		
		
		Date d = new Date();
		System.out.println(d);
		
		String fileName  = d.toString().replace(":","_").replace(" ", " _")+".jpeg";
		
		 System.out.println(fileName);
		
		
		
		
		
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(SrcFile, new File("C:\\Chromedriver104\\" + fileName));
		
		driver.findElement(By.id("lbLoginOut")).click();
	}

}
