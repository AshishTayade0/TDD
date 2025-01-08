package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.time.Duration;

public class driverManager {
    protected static WebDriver driver;


    @BeforeTest
    public void testInit(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void testTearDown(){
        if(!(driver == null)){
            driver.quit();
        }
    }
}
