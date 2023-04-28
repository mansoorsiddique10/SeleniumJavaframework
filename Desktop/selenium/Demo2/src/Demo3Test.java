

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
  
 public class Demo3Test {
  WebDriver driver;
  String url = "http://10.82.180.36/Common/Login.aspx";
 
  @Before
public void setup() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","Downloads\\Chromedriver.exe");
	  		driver = new ChromeDriver();
	  		driver.get(url);
  }

  @Test
  public void test() {
	String pageTitle = driver.getTitle(); 
  System.out.println(pageTitle);
  }
 
 
