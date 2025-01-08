package SmokeTest;

import WebDriverManager.driverManager;
import com.Pages.SignInPage;
import org.testng.annotations.Test;

public class ValidateSignInWithIdentityProviderTest extends driverManager {
    @Test
    public void verifyThatUserIsAbleToSignInWithIdentityProvider_WhenUserUsesUnderscoreInUserNameField(){
        driver.get("https://github.com/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.sendKeysToUserNameTextBox("User_1");
        signInPage.signInWithYourIdentityProviderButtonIsDisplayed();

    }
}
