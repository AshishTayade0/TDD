package WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class driverManager {
    protected static WebDriver driver;
    protected static ChromeOptions options;
    protected static ExtentReports extent; // Static to share across test lifecycle
    protected static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void initExtentReport() {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add System Info
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", "PROD");
        extent.setSystemInfo("QA", "James Bond");
    }

    @BeforeTest(alwaysRun = true)
    public void initBrowser() {
        // Initialize WebDriver

        // Configure ChromeOptions for headless mode
        options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--window-size=1920,1080"); // Set window size
        options.addArguments("--disable-gpu"); // Recommended for headless mode
        options.addArguments("--disable-dev-shm-usage"); // Optimize performance

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod(alwaysRun = true)
    public void createTest(Method method) {
        // Validate ExtentReports instance
        if (extent == null) {
            throw new IllegalStateException("ExtentReports instance is null. Ensure @BeforeSuite is executed.");
        }
        test = extent.createTest(method.getName(), "Automated test: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void logTestResult(ITestResult result) {
        if (test != null) {
            switch (result.getStatus()) {
                case ITestResult.SUCCESS -> test.pass("Test passed successfully!");
                case ITestResult.FAILURE -> {
                    test.fail("Test failed: " + result.getThrowable());
                    String screenshotPath = takeScreenshot(result); // Capture a screenshot
                    if (screenshotPath != null) {
                        test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot"); // Add screenshot to the report
                    }
                }
                case ITestResult.SKIP -> test.skip("Test skipped: " + result.getThrowable());
            }
        }
    }

    private String takeScreenshot(ITestResult result) {
        try {
            // Capture screenshot using WebDriver
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define screenshot path
            String screenshotPath = System.getProperty("user.dir") + "Reports/screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";

            // Save the screenshot
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));

            // Return the path of the screenshot
            return screenshotPath;
        } catch (Exception e) {
            test.warning("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }



    @AfterTest(alwaysRun = true)
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownExtentReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
