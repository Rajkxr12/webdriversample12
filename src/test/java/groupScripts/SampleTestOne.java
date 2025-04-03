package groupScripts;

import org.testng.annotations.Test;

public class SampleTestOne {
	@Test(groups="one")
	  public void testOne() {
		  System.out.println("Test 11 is Sample One...");
	  }
	  
	  @Test(groups="ft2")
	  public void testTwo() {
		  System.out.println("Test 12 is Sample One...");
	  }
	  
	  @Test(groups="ft3")
	  public void testThree() {
		  System.out.println("Test 13 is Sample One...");
	  }
}
