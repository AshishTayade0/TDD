package com.Pages;

import com.Utils.TakeScreenshot;
import com.WebDriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    TakeScreenshot takeScreenshot;
    protected  static WebDriver driver;
    private final By productButton = By.xpath("//button[contains(text(),'Product')]");
    private final By solutionsButton = By.xpath("//button[contains(text(),'Solutions')]");
    private final By resourcesButton = By.xpath("//button[contains(text(),'Resources')]");
    private final By openSourceButton = By.xpath("//button[contains(text(),'Open Source')]");
    private final By enterPriceButton = By.xpath("//button[contains(text(),'Enterprise')]");
    private final By pricingHyperLink = By.xpath("//a[@href='https://github.com/pricing']");
    private final By signInHyperLink = By.linkText("Sign in");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void productButtonIsDisplayed(){
        driver.findElement(productButton).isDisplayed();
    }
    public void solutionButtonIsDisplayed(){
        driver.findElement(solutionsButton).isDisplayed();
    }
    public void resourcesButtonIsDisplayed(){
        driver.findElement(resourcesButton).isDisplayed();
    }
    public void openSourceButtonIsDisplayed(){
        driver.findElement(openSourceButton).isDisplayed();
    }
    public void enterpriceButtonIsDisplayed(){
        driver.findElement(enterPriceButton).isDisplayed();
    }
    public void pricingHyperLinkIsDisplayed(){
        driver.findElement(pricingHyperLink).isDisplayed();
    }
    public void signInHyperLinkIsDisplayed(){
        driver.findElement(signInHyperLink).isDisplayed();
    }
    public SignInPage signInHyperLinkClick(){
        driver.findElement(signInHyperLink).click();
        return new SignInPage(driver);
    }
}
