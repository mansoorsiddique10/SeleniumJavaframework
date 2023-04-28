import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Demo_try {
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";
	
	@Before
	public void setUp()
	{	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
	driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	@Test
	public void test() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys("donhere");
					
		driver.findElement(By.xpath("//*[@id=\"body_txtPassword\"]")).sendKeys("don@123");
			
		driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/table/tbody/tr[3]/td[2]/div/table/tbody/tr[5]/td[3]/input")).click();
				

		
		driver.findElement(By.xpath("//*[@id=\"AccountCustomer_ul\"]/li[4]/a")).click();
		Thread.sleep(3000);
		
	
		WebElement AccNo = driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo"));

		Select select = new Select(AccNo);

		select.selectByIndex(3);
		
		driver.findElement(By.id("body_cph_MyAccount_rblTransactions_0")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$btnViewTrancastions")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"lbLoginOut\"]")).click();
		Thread.sleep(3000);
			}
	
	@After
	public void tearDown()
	{
		driver.close();
		
	}

}

