package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    protected static WebDriver driver;
    private By usernameTextBox = By.id("login_field");
    private By passwordTextBox = By.id("password");
    private By signInButton = By.xpath("//input[@value='Sign in']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
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

}
