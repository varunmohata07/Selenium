package TestNgModules;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {
		 @Test
		    public void testCase1() {
		        //selenium code to composemail
		        System.out.println("Compose mail");
		    }
		    @BeforeMethod
		    public void bmethod() {
		        System.out.println("openBrowser, Enter url, Login");
		    }
		    @BeforeClass
		    public void bclass() {
		        System.out.println("Start server...");
		    }
		    @AfterClass
		    public void aclass() {
		        System.out.println("Shutdown server...");
		    }
		    @AfterMethod
		    public void amethod() {
		        System.out.println("Logout,CloseBrowser");
		    }
		    
		    @Test
		    public void testCase2() {
		        //selenium code to savemail
		        System.out.println("savemail");
		    }
		    
		    @Test
		    public void testCase3() {
		        //selenium code to Deletemail
		        System.out.println("Deletemail");
		    }
}
