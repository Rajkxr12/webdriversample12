package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookSearchTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://danube-webshop.herokuapp.com/");
	}

//  @BeforeMethod
//  public void setup() {
//	  
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	  driver.get("https://danube-webshop.herokuapp.com/");
//  }

	@Test(priority=0)
	public void CrimeNovelsearch() {

		driver.findElement(By.xpath("//a[contains(text(), 'Crime & Thrillers')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("crime"));
	}

	@Test(enabled=false)
	public void FantasyBook() {

		driver.findElement(By.xpath("//a[contains(text(), 'Fantasy')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("fantasy"));
	}

	@Test(priority=1)
	public void CookingBook() {

		driver.findElement(By.xpath("//a[contains(text(), 'Cooking')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("cooking"));
	}

	@Test(dependsOnMethods = "CookingBook")
	public void HistoryBook() {

		driver.findElement(By.xpath("//a[contains(text(), 'History')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("history"));
	}

//  @AfterMethod
//  public void tearDown() {
//	  driver.quit();
//  }

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
