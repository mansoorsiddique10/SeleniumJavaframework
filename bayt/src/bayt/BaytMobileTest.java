package bayt;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaytMobileTest {

    private WebDriver driver;

    @BeforeMethod
	@BeforeTest
    public void setUp() {
        // Define the browser and URL
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bayt.com/en/uae/");
    }

    @Test
    public void testJobApplication() throws InterruptedException, IOException {
        // Resize the window to simulate a mobile screen
    	 
    	
        driver.manage().window().setSize(new Dimension(375, 812));
       
        Thread.sleep(1000);

      WebElement searchField = driver.findElement(By.xpath("//*[@id=\"text_search1\"]"));
      searchField.click();
      WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div[1]/div[2]/div/input")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div[2]/div/input")).sendKeys("Quality Assurance");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div[1]/div[3]/ul")));
        WebElement searchResults1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div[1]/div[3]/ul")));
        searchResults1.findElement(By.xpath("/html/body/div[11]/div[1]/div[3]/ul/li[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navUseAppBtn\"]/button")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search_icon_submit_1\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"results_inner\"]/div[1]/div[1]/div/div[2]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"results_inner_card\"]/ul/li[2]/div/div[3]/div[2]/a")).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div/div[1]/h5")));
        takeScreenshot("registrationpage.png");
        Thread.sleep(1000);
       

    }

    @AfterMethod
	@AfterTest
    public void tearDown() {
        // Close the browser after the test
 
        driver.quit();
    }
    private void takeScreenshot(String fileName) throws IOException {
    	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		Files.copy(f,new File("C:\\Users\\mansoor.hussain\\Desktop\\bayt\\"+fileName));
    }
}