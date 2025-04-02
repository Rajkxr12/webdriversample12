package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TooltipTest {
  @Test
  public void toolTip() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  
	  driver.get("https://jqueryui.com/tooltip/");
	  
	  driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	  
	  driver.findElement(By.id("age")).sendKeys(Keys.ARROW_DOWN);
	  actions.moveToElement(driver.findElement(By.id("age"))).perform();
	  
	  String Txt = driver.findElement(By.className("ui-tooltip-content")).getText();
	  Assert.assertEquals(Txt, "We ask for your age only for statistical purposes.");
	  driver.findElement(By.id("age")).sendKeys("23");
	  
	  driver.switchTo().defaultContent();
	  
	  String header = driver.findElement(By.tagName("h1")).getText();
	  System.out.println(header);
	  
	  driver.quit();
	  
  }
}
