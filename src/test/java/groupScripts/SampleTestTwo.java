package groupScripts;

import org.testng.annotations.Test;

public class SampleTestTwo {
	@Test(groups="one")
	  public void testOne() {
		  System.out.println("Test 21 is Sample Two...");
	  }
	  
	  @Test(groups="ft2")
	  public void testTwo() {
		  System.out.println("Test 22 is Sample Two...");
	  }
	  
	  @Test(groups="ft3")
	  public void testThree() {
		  System.out.println("Test 23 is Sample Two...");
	  }
}
