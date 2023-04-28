import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo10_dragndrop {
	WebDriver driver;
	String url = "http://10.82.181.42/Automation/DemoApps/Drag'N'Drop.aspx";
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
	 WebElement fromElement = driver.findElement(By.id("draggable"));
	 
	 WebElement toElement = driver.findElement(By.id("droppable"));
	 
	 Actions action =  new Actions(driver);
	 Thread.sleep(5000);
	 		action.dragAndDrop(fromElement, toElement).perform();
	 		
	 		
	 		
	 		String message = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
	 		 System.out.println("The message is " + message) ;
	}

}
