import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;

public class Demo4_login_logout {
	WebDriver driver;
 String url = "http://10.82.180.36/Common/Login.aspx";
 
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.getCurrentUrl();
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
	driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
	Thread.sleep(2000);
	driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
	Thread.sleep(2000);
	driver.findElement(By.name("ctl00$body$btnLogin")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("lbLoginOut")).click();
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Forgot")).click();
		}

}
