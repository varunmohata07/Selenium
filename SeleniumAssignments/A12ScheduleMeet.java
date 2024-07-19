package SeleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A12ScheduleMeet {
	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() throws InterruptedException {
		if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		// Implicit wait

		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/crm/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		// Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		
		//Meeting
		String subject = "Varun's Induction Meet";
		
		driver.findElement(By.id("grouptab_3")).click();
		driver.findElement(By.id("moduleTab_9_Meetings")).click();
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']//ul//li//a[@data-action-name='Schedule_Meeting']")).click();

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(subject);
		driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")).click();
		
		
		//View List
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']//ul//li//a[@data-action-name='List']")).click();
		
		
		Assert.assertEquals(driver.findElement(By.xpath("(//tbody//tr//td[@field='name'])[1]")).getText(), subject);

		driver.close();
		
	}
}