package TestNgModules;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertStatement {
	
	@Test
    public void testCase1() {
        int ExpLinks = 10;
        int ActLinks = 12; // selenium code
        
        SoftAssert sf = new SoftAssert();
        
        System.out.println("A");
        
        sf.assertEquals(ActLinks, ExpLinks);

        System.out.println("B");
        
        sf.assertEquals(ActLinks, ExpLinks);
        sf.assertAll();
        
        System.out.println("Passed with Soft Asserts");

	
	}
}
