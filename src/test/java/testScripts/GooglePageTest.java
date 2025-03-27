package testScripts;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class GooglePageTest {
	
	
  @Test
  public void SeleniumSearch() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
//	  driver.get("https://www.google.com/");
//	  WebElement searchbox = driver.findElement(By.id("APjFqb"));
//	  searchbox.sendKeys("Selenium tutorial", Keys.ENTER);
	  
	  driver.get("https://the-internet.herokuapp.com/login");
	  WebElement name = driver.findElement(By.id("username"));
	  name.sendKeys("tomsmith");
	  WebElement passwd = driver.findElement(By.id("password"));
	  passwd.sendKeys("SuperSecretPassword!");
	  WebElement loginbtn = driver.findElement(By.className("radius"));
	  loginbtn.click();
	  driver.quit();
  }
}
