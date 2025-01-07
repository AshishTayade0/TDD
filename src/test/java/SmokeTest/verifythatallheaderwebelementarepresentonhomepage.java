package SmokeTest;

import WebDriverManager.driverManage;
import com.Pages.HomePage;
import org.testng.annotations.Test;

public class verifythatallheaderwebelementarepresentonhomepage extends driverManage {
    @Test
    public void validateGitHubHomePage_SmokeTest(){
        driver.get("https://github.com");
        HomePage homePage = new HomePage(driver);
        homePage.productButtonIsDisplayed();
        homePage.solutionButtonIsDisplayed();
        homePage.resourcesButtonIsDisplayed();
        homePage.openSourceButtonIsDisplayed();
        homePage.enterpriceButtonIsDisplayed();
        homePage.pricingHyperLinkIsDisplayed();
        homePage.signInHyperLinkClick();
    }
}
