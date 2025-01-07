package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    protected static WebDriver driver;
    private final By usernameTextBox = By.id("login_field");
    private final By passwordTextBox = By.id("password");
    private final By signInButton = By.xpath("//input[@value='Sign in']");
    private final By signInWithYourIdentityProviderButton = By.xpath("//input[@value='Sign in with your identity provider']");

    public SignInPage(WebDriver driver){
        SignInPage.driver =driver;
    }

    public void sendKeysToUserNameTextBox(String username){
        WebElement usernameTB = driver.findElement(usernameTextBox);
        usernameTB.sendKeys(username);
    }
    public void sendKeysToPasswordTextBox(String password){
        WebElement usernameTB = driver.findElement(passwordTextBox);
        usernameTB.sendKeys(password);
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
    public void signInWithYourIdentityProviderButtonIsDisplayed(){
        driver.findElement(signInWithYourIdentityProviderButton).isDisplayed();
    }

}
