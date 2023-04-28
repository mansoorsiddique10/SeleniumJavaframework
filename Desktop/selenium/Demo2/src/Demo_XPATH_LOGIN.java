import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_XPATH_LOGIN {
	WebDriver driver;
	String url = ("http://10.82.180.36/Common/Login.aspx");

	
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
	}



	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys("donhere");
		driver.findElement(By.xpath("//*[@id=\"body_txtPassword\"]")).sendKeys("done@123");
		
	}

}
