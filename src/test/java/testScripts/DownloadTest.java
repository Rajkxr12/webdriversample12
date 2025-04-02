package testScripts;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DownloadTest {
  @Test
  public void fileDownload() throws IOException, InterruptedException {
	  
	  ChromeOptions option = new ChromeOptions();
	  
	  Map<String, Object> prefs = new HashMap<String, Object>();
	  prefs.put("download.prompt_for_download", false);
	  
	  option.setExperimentalOption("prefs", prefs);
	  
	  WebDriver driver = new ChromeDriver(option);
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.selenium.dev/downloads/");
	  
	  Actions action = new Actions(driver);
	  Thread.sleep(5000);
	  
	  action.scrollByAmount(100, 900).perform();
	  driver.findElement(By.xpath("//a[text()='4.30.0']")).click();
	  
//	  driver.quit();
  }
}
