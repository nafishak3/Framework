package com.qa.CRM.pages.util;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil extends TestListenerAdapter {


/**
 * From selenium 4 we can take screenshot at (element, section and also full-page level).
 * Element means for one particular web element.
 * Section means any particular table, form or block of element altogether.
 * Full-page screenshot can be takes two ways.
 * getScreenshotAs() – This Selenium 4 method allows us to capture a screenshot of a particular WebElement (only visible part of the website).
 * getFullPageScreenshotAs() – This method of Selenium 4 allows us to take full page screenshot in Firefox (top to bottom).
  */


    /**
     * This method is used to take the full page level screenshot
     * it will return a path of screenshot
     */

    public void onTestFailure(ITestResult testResult) {
        String path = "src/main/java/Screenshots/";

        File screenShot = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path + testResult.getName() + System.currentTimeMillis() + ".png");

        try {
            FileUtils.copyFile(screenShot, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
