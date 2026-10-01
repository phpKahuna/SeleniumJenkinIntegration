
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", "c:\\web-drivers\\chromedriver.exe");
        
        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
        @Test
    public void test1() {
        //System.out.println("test 1");

            WebElement text = driver.findElement(By.xpath("//span[text()='Products']"));

            String originalText = "Products";
            String expectedText = text.getText();
            Assert.assertEquals(originalText,expectedText);
    }

    @AfterClass
    public void afterClass() {
        // Close the WebDriver instance
        driver.quit();
    }
}
