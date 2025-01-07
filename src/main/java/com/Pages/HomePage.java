package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected  static WebDriver driver;

    private By productButton = By.xpath("//button[contains(text(),'Product')]");
    private By solutionsButton = By.xpath("//button[contains(text(),'Solutions')]");
    private By resourcesButton = By.xpath("//button[contains(text(),'Resources')]");
    private By openSourceButton = By.xpath("//button[contains(text(),'Open Source')]");
    private By enterpriceButton = By.xpath("//button[contains(text(),'Enterprise')]");
    private By pricingHyperLink = By.xpath("//a[@href='https://github.com/pricing']");
    private By signInHyperLink = By.xpath("//a[contains(text(),'Sign in')]");

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
        driver.findElement(enterpriceButton).isDisplayed();
    }
    public void pricingHyperLinkIsDisplayed(){
        driver.findElement(pricingHyperLink).isDisplayed();
    }
    public void signInHyperLinkIsDisplayed(){
        driver.findElement(signInHyperLink).isDisplayed();
    }
    public void signInHyperLinkClick(){
        driver.findElement(signInHyperLink).click();
//        boolean available = driver.findElement(signInHyperLink).isDisplayed();
//        if(!available) {
//            driver.findElement(signInHyperLink).click();
//        }
//        else {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.elementToBeClickable(signInHyperLink));
//        }
    }
}
