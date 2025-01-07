package RegressionTest;

import WebDriverManager.driverManager;
import com.Pages.SignInPage;
import org.testng.annotations.Test;

public class ValidateLoginFunctionalityFromLoginPageTest extends driverManager {
    @Test
    public void verifyLoginFunctionality_SignInFromLoginPage(){
        driver.get("https://github.com/login"); // this can be use derive from pom.xml properties
        SignInPage signInPage = new SignInPage(driver);
        signInPage.sendKeysToUserNameTextBox("admin");
        signInPage.sendKeysToPasswordTextBox("admin");
        signInPage.clickSignInButton();
    }
}
