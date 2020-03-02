package JenkinExample;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NewTest
{
	public WebDriver driver;
	private static Logger Log = Logger.getLogger(Logs.class.getName());
  @Test
  public void main() throws InterruptedException {
	  driver.findElement(By.id("textusername")).sendKeys("diuser");
	  Log.info("username entered in userid text box");
	  Thread.sleep(500);
	  driver.findElement(By.id("txtpassword")).sendKeys("1q2w3e4r!");
	  Log.info("password entered in password text box");
	  Thread.sleep(500);
	  driver.findElement(By.id("login")).click();
	  Log.info("click action performed on login button");
	  Reporter.log("Sign In Successful | " );
	  System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	  Thread.sleep(5000);
	  driver.findElement(By.id("lbuser")).click();
	  Log.info("click action performed");
	  Thread.sleep(10000);
	  //driver.findElement(By.xpath("//*[@id='navbar-mobile']/ul/li[2]/div/a")).click();
		
		  WebElement element =
		  driver.findElement(By.xpath("//*[@id='navbar-mobile']/ul/li[2]/div/a"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click()", element);
		 
	 	  Log.info("click actions performed on logout button");
	  Thread.sleep(5000);
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Test\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  Log.info("driver initialised");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Log.info("Implicit wait applied on the driver for 10 seconds");
	  driver.get("http://192.168.23.253/costcenterCloud/LoginFrm.aspx");
	  driver.manage().window().maximize();
	  Log.info("Web application launched");
	  Reporter.log("Application Lauched successfully | ");

  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  Log.info("Browser closed");
	  Reporter.log("User is Logged out and Application is closed | ");
  }

}



