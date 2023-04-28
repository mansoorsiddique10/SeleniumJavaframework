import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_multiple_window_contactus {
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
	public void test() {
		driver.findElement(By.xpath("//*[@id=\"header_right\"]/a[2]")).click();
		
		
		Set<String> windowsHandle = driver.getWindowHandles();
		System.out.println(windowsHandle.size());
		
		
		for(String str: windowsHandle)
		{
			String currentUrl = driver.getCurrentUrl();
			
			driver.switchTo().window(str);
			if(currentUrl.equals("http://10.82.180.36/Common/ContactUs.aspx"));
			{
				break;
			}
			
	
		}
			
				
				String message = driver.findElement(By.xpath("//*[@id=\"templatemo_wrapper\"]/h4[1]/b")).getText();
			System.out.println("the message is : " + message);
				
		
				
				
			//*[@id="templatemo_wrapper"]/h4[1]/b
		}
	}


