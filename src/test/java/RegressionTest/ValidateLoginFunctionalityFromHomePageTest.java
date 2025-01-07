package RegressionTest;

import WebDriverManager.driverManager;
import com.Pages.HomePage;
import com.Pages.SignInPage;
import org.testng.annotations.Test;

public class ValidateLoginFunctionalityFromHomePageTest extends driverManager {
    @Test
    public void verifyLoginFunctionality_SignInFromHomePage() throws InterruptedException {
        driver.get("https://github.com"); // this can be use derive from pom.xml properties
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.signInHyperLinkClick();
        signInPage.sendKeysToUserNameTextBox("admin");
        signInPage.sendKeysToPasswordTextBox("admin");
    }

}
