package com.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverFactory {

    public static WebDriver createDriver() {
        // Load configuration
        Properties config = ConfigReader.loadConfig("config.properties");

        // Get the browser type from the config
        String browser = config.getProperty("browser");
        WebDriver driver = null;

        // Create driver based on browser
        if (browser != null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    // Uncomment and configure as needed
                     driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else {
            throw new IllegalArgumentException("Browser not specified in configuration");
        }
        return driver;
    }
}
