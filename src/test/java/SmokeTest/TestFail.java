package SmokeTest;

import WebDriverManager.driverManager;
import com.Pages.HomePage;
import org.testng.annotations.Test;

public class TestFail extends driverManager {
    //"Intentionally cause the test to fail to verify its failure is reflected in the report."
    @Test
    public void failTest(){
        driver.get("https:google.com");
        HomePage homePage = new HomePage(driver);
        homePage.solutionButtonIsDisplayed();

    }
}
