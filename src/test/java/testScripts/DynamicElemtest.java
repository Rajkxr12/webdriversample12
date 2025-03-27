package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicElemtest {
	
	String PrName = "Samsung galaxy s7";
	
  @Test
  public void dynamicElemnTest() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://demoblaze.com/");
	  Thread.sleep(3000);
	  List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
	  
	  for (WebElement item: items) {
		  System.out.println(item);
		  if (item.getText().equalsIgnoreCase(PrName)) {
			  item.click();
			  break;
		  }
	  }
	  
//	  driver.quit();
	  
  }

}
