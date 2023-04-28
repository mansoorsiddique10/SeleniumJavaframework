import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo_dropdown_radiatest {
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";


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
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys("donhere");
	
		driver.findElement(By.xpath("//*[@id=\"body_txtPassword\"]")).sendKeys("don@123");
	
		driver.findElement(By.xpath("//*[@id=\"body_btnLogin\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"GeneralTabMenu_Deposit_li_Cust\"]/span")).click();
	
		driver.findElement(By.xpath("//*[@id=\"body_pnlCustomer_SubMenu\"]/div/div/ul/li[3]/a")).click();
	
		driver.findElement(By.xpath("//*[@id=\"body_cph_Deposit_rbtnDepositType\"]/tbody/tr/td[1]/label")).click();

		
		
		  WebElement dropdown = driver.findElement(By.name("ctl00$ctl00$body$cph_Deposit$ddlMyDeposits"));
		  
		  Thread.sleep(2000); 
		  
		  Select select =new Select(dropdown);
		  Thread.sleep(2000); 
		  
		   select.selectByIndex(4);
		   driver.findElement(By.xpath("//*[@id=\"tblTransferMoney\"]/tbody/tr[2]/td[3]]")).click();
		   Thread.sleep(4000);
		  driver.findElement(By.xpath("body_cph_Deposit_upnlCloseDepositAccount")).click();
		  Thread.sleep(4000);
		  
		  
		  driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@id=\\\"body_cph_Deposit_rbtnDepositType\\\"]/tbody/tr/td[1]/label\")).click();")).click();
		  
		  Thread.sleep(4000);
		  
		  
		  
		  
		  
		  String expectedMessages = "Already a request is raised";
			
			String actualMessage = driver.findElement(By.id("body_cph_Deposit_lblMessages")).getText();
			Assert.assertEquals(expectedMessages, actualMessage);
			
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"lbLoginOut\"]")).click();
			
		  
		  
		  
		  
		  
		  
		 
		
		
		
	}

}
