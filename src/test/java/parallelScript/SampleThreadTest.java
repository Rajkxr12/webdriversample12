package parallelScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleThreadTest {
	WebDriver driver;
	
	@Test
	  public void testOne() {
		driver = new ChromeDriver();
		long id = Thread.currentThread().getId();
		  System.out.println("Test 11 is Sample One..."+id);
	  }
	  
	  @Test
	  public void testTwo() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 12 is Sample One..."+id);
	  }
	  
	  @Test
	  public void testThree() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 13 is Sample One..."+id);
	  }
}
