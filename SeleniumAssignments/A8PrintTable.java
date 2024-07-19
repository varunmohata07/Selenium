package SeleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A8PrintTable {
	public class Test8 {
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

			// implicit wait
			
			driver.manage().window().maximize();
			driver.get("https://alchemy.hguy.co/crm/");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			// Login
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.id("bigbutton")).click();

			// Go in Table
			driver.findElement(By.id("grouptab_0")).click();
			driver.findElement(By.id("moduleTab_9_Accounts")).click();

			Thread.sleep(2500);
			List<WebElement> ll = driver.findElements(By.xpath("//tbody//tr//td[@field='name']"));
			System.out.println(ll.size());

			for (int i = 0; i < 10; i+=2) {
				System.out.println(ll.get(i).getText());
			}

			driver.close();

		}
	}

}
