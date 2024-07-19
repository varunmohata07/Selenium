package SeleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A7ReadPopup {
	public class Test7 {
//			WebDriver driver = new ChromeDriver();
		WebDriver driver;
		String Browser = "firefox";

		@Test
//				WebDriver driver = new ChromeDriver();	
		public void testCase1() throws InterruptedException {
			if (Browser.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();

			else if (Browser.equalsIgnoreCase("firefox"))
				driver = new FirefoxDriver();

			else if (Browser.equalsIgnoreCase("edge"))
				driver = new EdgeDriver();

			// soft assert
			SoftAssert st = new SoftAssert();

			driver.manage().window().maximize();
			driver.get("https://alchemy.hguy.co/crm/");
			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Login
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.id("bigbutton")).click();
			
			//Printing from Popup
			driver.findElement(By.id("grouptab_0")).click();
			driver.findElement(By.id("moduleTab_9_Leads")).click();
			
			driver.findElement(By.xpath("(//span[@class='suitepicon suitepicon-action-info'])[1]")).click();
			String mobile = driver.findElement(By.xpath("(//div[@class='open ui-dialog-content ui-widget-content'] //span[@class='phone'])[1]")).getText();
			System.out.println(mobile);
			
			driver.close();
			
		}
	}

}
