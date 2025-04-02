package testScripts;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecTest {
  @Test
  public void JsTest() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  String title = (String) js.executeScript("return document.title");
	  System.out.println(title);
	  
	  WebElement inptName = (WebElement) js.executeScript("return document.getElementById('name')");
	  inptName.sendKeys("testUser");
	  
	  js.executeScript("window.scrollBy(100, document.body.scrollHeight)");
	  
	  driver.quit();
  }
}
