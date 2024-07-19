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

public class A14FilteringProducts {
	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() {
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

		driver.findElement(By.xpath("//a[text()='Sales']")).click();

		driver.findElement(By.xpath("//ul//li//a[text()='Opportunities']")).click();
		
		driver.findElement(By.xpath("//a[@title='Filter']")).click();
		
		driver.findElement(By.xpath("//a[text()='Advanced Filter']")).click();
		
		driver.findElement(By.xpath("//option[@label='Less Than']")).click();
		
		// Assigned To 
		driver.findElement(By.xpath("//option[@label='sarah']")).click();
	
		// Sales Page
		driver.findElement(By.xpath("//option[@label='Perception Analysis']")).click();
		
		// Lead Source
		driver.findElement(By.xpath("//option[@label='Web Site']")).click();

		// Directions
		driver.findElement(By.xpath("//input[@id='sort_order_desc_radio']")).click();
		
		// Click Search Button
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		// Print name only
		List<WebElement>li = driver.findElements(By.xpath("//tbody//tr//td[@field='name']"));

		if(li.size() == 0) {
			System.out.println("No results found... Perhaps change your search criteria and try again?");
		}else {
			for(int i = 0; i < li.size(); i++) {
				System.out.println(li.get(i).getText());
			}
		}
		
		// Reset Button
		driver.findElement(By.xpath("//li[@class='sugar_action_button desktopOnly']")).click();
		
		
	}
	
}
