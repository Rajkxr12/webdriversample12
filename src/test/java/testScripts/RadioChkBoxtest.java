package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioChkBoxtest {
  @Test
  public void selectRadioBtn() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
//	  driver.get("https://the-internet.herokuapp.com/checkboxes");
//	  
//	  driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
//	  boolean isSel = driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected();
//	  
//	  if (isSel) {
//		  
//		  driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
//	  }
	  
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  driver.findElement(By.xpath("//input[@value='male']")).click();
	  boolean isSelec = driver.findElement(By.xpath("//input[@value='female']")).isSelected();
 
	  if (isSelec) {
		  
		  driver.findElement(By.xpath("//input[@value='female']")).click();
	  }
	  
	  
  } 
  
}
