package SmokeTest;

import WebDriverManager.driverManager;
import com.Pages.HomePage;
import org.testng.annotations.Test;

public class ValidateHeaderElementOfGithubHomepageTest extends driverManager {
    @Test
    public void verifyThatAllHeaderElementArePresentOnHomePage(){
        driver.get("https://github.com"); // this can be use derive from pom.xml properties
        HomePage homePage = new HomePage(driver);
        homePage.productButtonIsDisplayed();
        homePage.solutionButtonIsDisplayed();
        homePage.resourcesButtonIsDisplayed();
        homePage.openSourceButtonIsDisplayed();
        homePage.enterpriceButtonIsDisplayed();
        homePage.pricingHyperLinkIsDisplayed();
        homePage.signInHyperLinkIsDisplayed();
    }
}
