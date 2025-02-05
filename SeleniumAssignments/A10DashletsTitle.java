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

public class A10DashletsTitle {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm/");

        // Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        
        // Search for Name and Assigned User
        List<WebElement> dashTitles = driver.findElements(By.xpath("//tbody//tr//td[@class='dashlet-title']"));


        for (int i = 0; i < 10; i++) {
            String name = dashTitles.get(i).getText();
            System.out.println(name);
        }

        driver.close();
    }
}
