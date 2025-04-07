package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utils;
public class BookSearchTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;

	@BeforeTest
	public void Extentsetup() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SaprkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
					ViewName.AUTHOR,
					ViewName.DASHBOARD,
					ViewName.TEST,
					ViewName.LOG,
					ViewName.DEVICE
				}).apply();
		extentReports.attachReporter(spark);

	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://danube-webshop.herokuapp.com/");
	}

	@Test(priority = 0)
	public void CrimeNovelsearch() {
		extentTest = extentReports.createTest("Crime test");
		driver.findElement(By.xpath("//a[contains(text(), 'Crime & Thrillers')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("crime"));
	}

	@Test(enabled = false)
	public void FantasyBook() {

		driver.findElement(By.xpath("//a[contains(text(), 'Fantasy')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("fantasy"));
	}

	@Test(priority = 1)
	public void CookingBook() {
		extentTest = extentReports.createTest("Fantasy test");
		driver.findElement(By.xpath("//a[contains(text(), 'Cooking')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("cking"));
	}

	@Test(priority = 2)
	public void HistoryBook() {
		extentTest = extentReports.createTest("History test");
		driver.findElement(By.xpath("//a[contains(text(), 'History')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("history"));
	}

  @AfterMethod
  public void tearDown(ITestResult result) {
	  extentTest.assignAuthor("AutomationTester 1")
	  .assignCategory("Regression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
	  
	  if(ITestResult.FAILURE==result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String path = Utils.getScreenshotPath(driver);
		  extentTest.addScreenCaptureFromPath(path);
	  }
//	  driver.quit();
  }

	@AfterTest
	public void finishExtent() {
		extentReports.flush();
	}

}
