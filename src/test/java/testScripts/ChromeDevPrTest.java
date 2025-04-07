package testScripts;

import java.util.HashMap;
import java.util.Map;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeDevPrTest {
	ChromeDriver driver;
	DevTools devTools;
	
  @BeforeMethod
  public void setup() {
	  driver = new ChromeDriver();
	  
	  devTools = driver.getDevTools();
	  devTools.createSession(driver.getWindowHandle()); 
  } 
  
  @Test
  public void deviceModeTest() {
	  Map deviceMetrics = new HashMap() {{
		  put("width", 800);
		  put("height", 1100);
		  put("deviceScaleFactor", 50);
		  put("mobile", true);
	  }};
	  
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	  driver.get("https://www.selenium.dev/");
	  driver.manage().window().maximize();
  }
  
 
@Test
  public void geoLocationTest() {
	  Map deviceMetrics = new HashMap() {{
		  put("latitude", 25.761681);
		  put("longitude", -80.191788);
		  put("accuracy", 100);
	  }};
	  
	  driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
	  driver.get("https://oldnavy.gap.com/stores");
	  driver.manage().window().maximize();
  }
  
}
