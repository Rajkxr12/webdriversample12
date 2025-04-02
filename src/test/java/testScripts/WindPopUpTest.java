package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindPopUpTest {
  @Test
  public void WindowHandle() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  
	  driver.get("https://demoqa.com/browser-windows");
	  
	  String parentWin = driver.getWindowHandle();
	  Thread.sleep(5000);
	  actions.scrollByAmount(100, 1200).perform();
	  System.out.println("ParentWindow: " + parentWin);
	  
	  driver.findElement(By.id("tabButton")).click();
	  System.out.println("Page title: " + driver.getTitle());
	  
	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("No.of.Windows: " + wins.size());
	  for(String child : wins) {
		  System.out.println("Window handle: " + child);
		  if(!child.equalsIgnoreCase(parentWin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(5000);
			  String h1TagText = driver.findElement(By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Text in Tab win: " + h1TagText);
		  }
	  }
	  
	  driver.quit();
  }
}
