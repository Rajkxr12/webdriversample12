package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebGridTest {
	RemoteWebDriver driver;

	@Test
	public void StorySearch() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//		options.setCapability(CapabilityType.BROWSER_VERSION, "120");

		String Hub = "http://10.0.12.17:4444";

		driver = new RemoteWebDriver(new URL(Hub), options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://danube-webshop.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(), 'Fantasy')]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("fantasy"));
	}
}
