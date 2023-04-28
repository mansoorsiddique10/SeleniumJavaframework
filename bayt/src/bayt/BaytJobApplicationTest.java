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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;
public class BaytJobApplicationTest {
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
    public void applyToJobTest() throws InterruptedException, IOException {
        // Step 1: Launch the Bayt.com website.
        driver.get("https://www.bayt.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        
        // Step 2: Scroll down to the page footer.
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        Thread.sleep(1000);
        
        
        // Step 3: Click on the "About Us" link.
        footer.findElement(By.xpath("//*[@id=\"yw3\"]/li[1]/a")).click();
        
        // Step 4: Wait for the page to load.
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/div[1]/h2")));
        
        
        // Step 5: Take a screenshot of the page.
        
        js.executeScript("window.scrollTo(0,600)");
        Thread.sleep(2000);
        takeScreenshot("about-us-page.png");
        
        
//         Step 6: Click on one of the jobs appearing under the "Apply to Bayt.com" section.
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/div/div[1]/h5/a")).click();
        driver.navigate().to("https://www.bayt.com/en/pakistan/jobs/software-engineer-4672834/");
        Thread.sleep(2000);
        takeScreenshot("job.png");
        
        
//        // Step 7: Wait for the page to load.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"card-0\"]/div[1]/h5")));
//
        
//        // Step 8: Take a screenshot of the page.
        takeScreenshot("job-details-page.png");
//
        
//        // Step 9: Apply for the job, then fill out the registration form.
     driver.findElement(By.xpath("//*[@id=\"applyLink_1\"]")).click();
     js.executeScript("window.scrollTo(0,480)");
     Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jsApplicantRegisterFormID\"]/div[2]/div[1]/div[1]/label")));

//        // Step 10: Fill out the registration form.
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_firstName\"]")).sendKeys("Ahsan");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_lastName\"]")).sendKeys("Ali");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_email\"]")).sendKeys("ahsan.haq2545@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_password\"]")).sendKeys("Ahsan@123");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_mobPhone\"]")).sendKeys("8960494586");

//        // Step 11: Submit the registration form.
        driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
        Thread.sleep(5000);
        
//        // Step 12: Check that there is a validation message in the form appearing when registering with an email that is already registered.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"JsApplicantRegisterForm_email_em_\"]")));
        js.executeScript("window.scrollTo(0,480)");
        Thread.sleep(3000);
        takeScreenshot("validation-error-page.png");
//
//        // Step 13: Generate a new email and fill out the registration form again.
        email = "test" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_email\"]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_email\"]")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
        Thread.sleep(2000);
        
        
//        // Step 14: Wait for the page to load.
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
        
        
        // Step 15: Take a screenshot of the page.
        Thread.sleep(3000);
        takeScreenshot("application-success-page.png");
    }

//	@Test(dependsOnMethods = "applyToJobTest")
	
//    public void login() throws InterruptedException, IOException {
//        // Step 1: Launch the Bayt.com website.
//		
//        driver.get("https://www.bayt.com/");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        
//       
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div[2]/h1")));
//      
//        driver.findElement(By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[1]/a")).click();
//        
//			 
//		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LoginForm_username\"]")));
//		     takeScreenshot("loginPage.png");
//		     Thread.sleep(1000);
//		     driver.findElement(By.xpath("//*[@id=\"LoginForm_username\"]")).sendKeys("ahsan.haq2545@gmail.com");
//		        driver.findElement(By.xpath("//*[@id=\"LoginForm_password\"]")).sendKeys("Ahsan@123");
//		        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
//		        Thread.sleep(1000);
//		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
//	        Thread.sleep(1000);
//	        takeScreenshot("dashboard-login-success.png");
//
//        
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw0\"]/section[1]/p")));
//	    Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/a")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul")));
//        Thread.sleep(1000);
//        
//        
//        
//        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul"));
//      
//        dropdown1.findElement(By.xpath("//*[@id=\"yw1\"]/li[13]/ul/li[7]/div/ul/li[1]")).click();
//        
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"personalInformation\"]/div[1]/h4")));
//        takeScreenshot("myAccount.png");
//        Thread.sleep(2000);
//        
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        Thread.sleep(2000);
//        js.executeScript("window.scrollBy(0,-300)");
//        Thread.sleep(4000);
//        takeScreenshot("DeleteAcc.png");
//        driver.findElement(By.xpath("/html/body/div[4]/section/div/div[13]/div[2]/p/a")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/div/div[1]/h3")));
//        takeScreenshot("ConfirmDPage.png");
//        js.executeScript("window.scrollBy(0,100)");
//        Thread.sleep(4000);
//        driver.findElement(By.xpath("/html/body/div[3]/section/div/div[2]/ul/li[1]/button")).click();
//        
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div")));
//        Thread.sleep(4000);
//        takeScreenshot("confirmDeleteModel.png");
//        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/button[2]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[1]/a")));
//        Thread.sleep(4000);
//        takeScreenshot("againLogin.png");
//        
//    }

    @AfterTest
    public void tearDown() {
    driver.quit();
    }
    private void takeScreenshot(String fileName) throws IOException {
    	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		Files.copy(f,new File("C:\\Users\\mansoor.hussain\\Desktop\\bayt\\"+fileName));
    }
}
   