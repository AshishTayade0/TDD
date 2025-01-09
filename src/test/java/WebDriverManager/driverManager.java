package WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class driverManager {
    protected static WebDriver driver;
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
        extent.setSystemInfo("QA", "Name");
    }

    @BeforeTest(alwaysRun = true)
    public void initBrowser() {
        // Initialize WebDriver
        driver = new ChromeDriver();
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
                case ITestResult.FAILURE -> test.fail("Test failed: " + result.getThrowable());
                case ITestResult.SKIP -> test.skip("Test skipped: " + result.getThrowable());
            }
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
