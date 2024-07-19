package AmazonTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v124.webauthn.model.CredentialAdded;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test3 {
//	WebDriver driver = new ChromeDriver();
	static WebDriver driver;
	static String Browser = "firefox";

	@Test
//		WebDriver driver = new ChromeDriver();	
	public void testCase3() throws InterruptedException {
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
		driver.get("https://www.amazon.com");

		// Handling Pop ups
		try {
			WebElement toastremove1 = driver.findElement(By.xpath(
					"//div[@class='a-section glow-toaster glow-toaster-theme-default glow-toaster-slot-default nav-coreFlyout nav-flyout']//input[@data-action-type='DISMISS']"));
			toastremove1.click();
		} catch (Exception e) {
			System.out.println("Exception Occurred....");
		}

		// Click Today's Deal
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
		Thread.sleep(1000);

		// See More
		driver.findElement(By.xpath("//a[@aria-labelledby='see-more-departments-label']")).click();

		// Musical Instruments Selected
		driver.findElement(
				By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[20]/div/label/span/span")).click();

		// Select Product
		driver.findElement(
				By.xpath("(//div[@class='a-section ProductCardImage-module__wrapper_YgLz4kq6ekChj01qeqOf'])[1]"))
				.click();

		// Selecting new Radio
		driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();

		// Add to cart
		driver.findElement(By.name("submit.add-to-cart")).click();

		String text = driver.findElement(By.xpath("//*[@id=\'NATC_SMART_WAGON_CONF_MSG_SUCCESS\']/h1")).getText();
		System.out.println("Actual text = " + text);
		
		//Assert to check 
		//st.assertEquals(text, "Added to Cart from Movie & TV"); ---//Negative
		st.assertEquals(text, "Added to Cart"); //--Positive Assert
		
		driver.quit();
		st.assertAll();
	}
}
