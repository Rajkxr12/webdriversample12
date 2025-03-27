package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
  @Test
  public void SelectValue() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  Select sel = new Select(driver.findElement(By.id("country")));
	  sel.selectByIndex(9);
	  
	  Select mulsel = new Select (driver.findElement(By.id("colors")));
	  if (mulsel.isMultiple()) {
		  
		  mulsel.selectByIndex(1);
		  mulsel.selectByValue("yellow");
		  mulsel.selectByVisibleText("White");
	  }
	  
	  
  }
}
