package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTests {
  @Test
  public void variousAlerts() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  driver.findElement(By.id("alertBtn")).click();
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
	  
	  driver.findElement(By.id("confirmBtn")).click();
	  Alert confrm = driver.switchTo().alert();
	  System.out.println(confrm.getText());
	  confrm.dismiss();
	  
	  driver.findElement(By.id("promptBtn")).click();
	  Alert prompt = driver.switchTo().alert();
	  System.out.println(prompt.getText());
	  prompt.sendKeys("Maharaj");
	  prompt.accept();
	  
	  driver.quit();
  }
}
