import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_packandgo_webelement {
	
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
		driver.close();
		
		
	
	
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[2]/a")).click();
		
		
		WebElement tblAccountDetails = driver.findElement(By.id("offersTable"));
	     List<WebElement> rows = tblAccountDetails.findElements(By.tagName("TR"));

	     
	     for (WebElement row : rows) {
	    	//Find all the cols inside the particular row using the td tag
	    	List<WebElement> cols = row.findElements(By.tagName("TD"));
	    				
	    	//Iterate over all the columns inside the particular row
	    	for (WebElement col : cols) {
	    	//Print the cell value
	    	System.out.print("Column value: " + col.getText());
	    	
	    	}
}
	}
}