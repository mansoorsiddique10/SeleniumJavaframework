import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_frames {
	WebDriver driver;
	String url = "http://10.82.181.42/Automation/DemoApps/FrameExample.aspx";
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		}

	
	@After
	public void tearDown() throws Exception {
		 driver.close(); 
	}

	@Test
	public void test() {
		driver.switchTo().frame(0);
		String messages = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[2]")).getText();
		System.out.println("the message is " + messages);
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		String message1 = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[2]")).getText();
		System.out.println("the message is " + message1);
		
		
	}

}
