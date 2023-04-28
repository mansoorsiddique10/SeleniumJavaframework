import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_packandgo_popup {
	WebDriver driver;
	String url = "http://10.82.180.255:81/Automation/PackAndGo_v2/";
	

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
		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("usernameLogin")).sendKeys("pgGru");
		driver.findElement(By.xpath("//*[@id=\"passwordLogin\"]")).sendKeys("freezeray");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		
		 WebElement fromsrc = driver.findElement(By.id("fromDD"));
		 Select selectFrom = new Select(fromsrc);
		 
		 selectFrom.selectByIndex(1);
		 
		 
		 
		 WebElement todes = driver.findElement(By.id("toDD"));
		 Select selectTo = new Select(todes);
		 selectTo.selectByIndex(1);
		 
		 driver.findElement(By.id("searchBus")).click();
		 
		 driver.findElement(By.id("radio3")).click();
		 
		 driver.findElement(By.id("book")).click();
		 driver.findElement(By.id("counter")).sendKeys("5");
		 
		 
		 driver.findElement(By.xpath("//*[@id=\"rowB6\"]/td/p/input")).click();
		 driver.switchTo().alert().dismiss();
		 
		 
		   driver.findElement(By.id("counter")).clear();
		   driver.findElement(By.id("counter")).sendKeys("5");
	        driver.findElement(By.xpath("//*[@id=\"rowB6\"]/td/p/input")).click();
	          
	          //Click on ConfirmBooking
	          driver.findElement(By.id("confirmBooking")).click();
	          
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
	
	}

}
