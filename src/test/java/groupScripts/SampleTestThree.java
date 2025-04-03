package groupScripts;

import org.testng.annotations.Test;

public class SampleTestThree {
  @Test(groups="one")
  public void testOne() {
	  System.out.println("Test 31 is Sample 3...");
  }
  
  @Test(groups="ft2")
  public void testTwo() {
	  System.out.println("Test 32 is Sample 3...");
  }
  
  @Test(groups="ft3")
  public void testThree() {
	  System.out.println("Test 33 is Sample 3...");
  }
  
  
}
