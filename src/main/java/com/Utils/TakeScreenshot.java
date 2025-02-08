package com.Utils;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenshot {
    public static void takeScreenshot(WebDriver driver, String filepath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        try {
            FileUtils.copyFile(screenshot, new File(filepath + "/screenshot_" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
