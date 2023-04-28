import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo9_popup {
	WebDriver driver;
	String url = "http://10.82.181.42/Automation/DemoApps/PopUpBox.aspx";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/input")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/input")).click();
		driver.switchTo().alert().dismiss();
		
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/input")).click();

		driver.switchTo().alert().sendKeys("Mansoor");
		driver.switchTo().alert().accept();
		
		  String message =
		  driver.findElement(By.xpath("//*[@id=\"lblMessage\"]")).getText();
		  System.out.println("The message is " + message );
		 
		
		
		
		
		
		
		
		
	}

}
