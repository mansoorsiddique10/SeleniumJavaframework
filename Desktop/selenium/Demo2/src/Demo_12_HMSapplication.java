import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_12_HMSapplication {
	WebDriver driver;
	String url = "http://10.82.181.42/Automation/HMS/LoginPage.aspx";

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		/* driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS); */
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		 driver.close(); 
	}

	@Test
	public void test() throws InterruptedException {
	driver.findElement(By.name("txtUserID")).sendKeys("127");
	driver.findElement(By.name("txtPassword")).sendKeys("admin");
	driver.findElement(By.name("btnLogin")).click();
	
	
	WebDriverWait wait = new WebDriverWait(driver,300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"NavigationMenu\\\"]/ul/li[4]/a")));
	
	
	//*[@id=\"NavigationMenu\"]/ul/li[4]/a
	
	WebElement employee = driver.findElement(By.xpath(""));
	
	
	WebElement details = driver.findElement(By.xpath("//*[@id=\"NavigationMenu:submenu:14\"]/li[1]/a"));
	 Actions action = new Actions(driver);
	 
	 action.moveToElement(employee).moveToElement(details).click().build().perform();
	 
	 
	 driver.findElement(By.xpath("//*[@id=\"cphMainContent_tcEmployeeDetails_tpUpdateQualifications_grdQualificationForAdmin_btnEdit_0\"]")).click();
	   
	 WebElement qual = driver.findElement(By.xpath("//*[@id=\"cphMainContent_tcEmployeeDetails_tpUpdateQualifications_grdQualificationForAdmin\"]/tbody/tr[1]/th[4]"));
	 
	 qual.clear();
	 qual.sendKeys("BCA");
	 
	 
	 WebElement year = driver.findElement(By.xpath("//*[@id=\"cphMainContent_tcEmployeeDetails_tpUpdateQualifications_grdQualificationForAdmin\"]/tbody/tr[1]/th[5]"));
	 
	 
	 year.clear();
	 year.sendKeys("2022");
	  
	 driver.findElement(By.xpath("//*[@id=\"cphMainContent_tcEmployeeDetails_tpUpdateQualifications_grdQualificationForAdmin_btnUpdateEdition_0\"]")).click();
	 
	 
	 
	 String message = driver.findElement(By.id("cphMainContent_tcEmployeeDetails_tpUpdateQualifications_lblEmpEditQuali")).getText();
	 
	  System.out.println("status:" + message);
	
	}
	
}
