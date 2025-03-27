package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActions {
  @Test
  public void mouseAction() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement txtField = driver.findElement(By.id("field2"));
	  actions.scrollToElement(txtField).perform();
//	  
//	  WebElement Btndb1 = driver.findElement(By.xpath("//button[contains(text(), 'Copy Text')]"));
//	  actions.doubleClick(Btndb1).perform();
	  
	  WebElement src = driver.findElement(By.id("draggable"));
	  WebElement target = driver.findElement(By.id("droppable"));
	  actions.dragAndDrop(src, target);
	  
  }
}
