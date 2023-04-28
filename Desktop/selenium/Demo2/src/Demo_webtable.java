import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_webtable {
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
	public void test() {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		driver.findElement(By.xpath("//*[@id=\"tblLogin\"]/tbody/tr[5]")).click();
		
		 WebElement table = driver.findElement(By.id("body_cph_MyAccount_gvAccountDetails"));
		 
		 List<WebElement> rows = table.findElements(By.tagName("TR"));
		 
		 System.out.println("the list size is" + rows.size());
		 
		for(WebElement row: rows)
		{
			List<WebElement> cols = row.findElements(By.tagName("TD"));
			
		for(WebElement col: cols)
		{
			System.out.println("the value is:" + col.getText());
		}

		
		}
		 
	}

}
