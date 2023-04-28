package bayt;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Bayt_Delete_account {
	 private WebDriver driver;
	    private String email;

	    @BeforeTest
	    public void setup() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        email = "test" + System.currentTimeMillis() + "@example.com";
	    }

	    @Test
	

	
    public void login() throws InterruptedException, IOException {
        // Step 1: Launch the Bayt.com website.
		
        driver.get("https://www.bayt.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div[2]/h1")));
      
        driver.findElement(By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[1]/a")).click();
        
			 
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LoginForm_username\"]")));
		     takeScreenshot("loginPage.png");
		     Thread.sleep(1000);
		     driver.findElement(By.xpath("//*[@id=\"LoginForm_username\"]")).sendKeys("ahsan.haq2545@gmail.com");
		        driver.findElement(By.xpath("//*[@id=\"LoginForm_password\"]")).sendKeys("Ahsan@123");
		        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		        Thread.sleep(1000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
	        Thread.sleep(1000);
	        takeScreenshot("dashboard-login-success.png");

        

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw0\"]/section[1]/p")));
	    Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul")));
        Thread.sleep(1000);
        
        
        
        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul"));
      
        dropdown1.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul/li[1]")).click();
        

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"personalInformation\"]/div[1]/h4")));
        takeScreenshot("myAccount.png");
        Thread.sleep(2000);
        
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-300)");
        Thread.sleep(4000);
        takeScreenshot("DeleteAcc.png");
        driver.findElement(By.xpath("/html/body/div[4]/section/div/div[13]/div[2]/p/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/div/div[1]/h3")));
        takeScreenshot("ConfirmDPage.png");
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/section/div/div[2]/ul/li[1]/button")).click();
        

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div")));
        Thread.sleep(4000);
        takeScreenshot("confirmDeleteModel.png");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[1]/a")));
        Thread.sleep(4000);
        takeScreenshot("againLogin.png");
        
    }

    @AfterTest
    public void tearDown() {
    driver.quit();
    }
    private void takeScreenshot(String fileName) throws IOException {
    	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		Files.copy(f,new File("C:\\Users\\mansoor.hussain\\Desktop\\bayt\\"+fileName));
    }
}
	
	
	


