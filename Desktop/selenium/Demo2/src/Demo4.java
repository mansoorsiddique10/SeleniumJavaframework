import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4 {
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";
		
	
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Chromedriver104\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test
	public void test() {
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		
	}

}
