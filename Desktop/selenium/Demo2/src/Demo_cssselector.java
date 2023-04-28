import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_cssselector {
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
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.cssSelector("input#body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("don@123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.buttonStyle")).click();
		
		Thread.sleep(2000);
		
		
		
		
		
		
	}

}
