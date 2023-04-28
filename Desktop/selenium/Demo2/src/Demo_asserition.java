import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_asserition {
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
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys("donhere");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"body_txtPassword\"]")).sendKeys("don@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"body_btnLogin\"]")).click();
		String expectedMessages = "Welcome Donehere";
		
		String actualMessage = driver.findElement(By.id("divWelcome")).getText();
		Assert.assertEquals(expectedMessages, actualMessage);
		
		System.out.println("after assertion");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lbLoginOut\"]")).click();
		
		
	
	}

}
