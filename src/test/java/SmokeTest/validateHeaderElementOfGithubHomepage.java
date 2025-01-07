package SmokeTest;

import WebDriverManager.driverManage;
import com.Pages.HomePage;
import org.testng.annotations.Test;

public class validateHeaderElementOfGithubHomepage extends driverManage {
    @Test
    public void verifyThatAllHeaderElementArePresentOnHomePage(){
        driver.get("https://github.com");
        HomePage homePage = new HomePage(driver);
        homePage.productButtonIsDisplayed();
        homePage.solutionButtonIsDisplayed();
        homePage.resourcesButtonIsDisplayed();
        homePage.openSourceButtonIsDisplayed();
        homePage.enterpriceButtonIsDisplayed();
        homePage.pricingHyperLinkIsDisplayed();
    }
}
