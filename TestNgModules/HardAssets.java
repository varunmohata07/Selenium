package TestNgModules;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssets {

	@Test
    public void testCase1() {
        int ExpLinks = 10;
        int ActLinks = 12; // selenium code
        
        
        
        System.out.println("A");
        
        Assert.assertEquals(ActLinks, ExpLinks);

        System.out.println("B");
        
        Assert.assertEquals(ActLinks, ExpLinks);

    }
}
