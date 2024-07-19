package SeleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A4Login {
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

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/crm/");

		// Login
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();

		// Check whether it is home or not
		System.out.println("Login Successfully!");
		String homeurl = driver.getCurrentUrl();
		st.assertEquals(homeurl, "https://alchemy.hguy.co/crm/index.php?module=Home&action=index");
	}
}
