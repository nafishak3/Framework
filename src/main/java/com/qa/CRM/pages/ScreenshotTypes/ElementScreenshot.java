package com.qa.CRM.pages.ScreenshotTypes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ElementScreenshot extends TestListenerAdapter{
    static WebDriver driver;
    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://classic.freecrm.com/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Up")));


        WebElement signUp = driver.findElement(By.linkText("Sign Up"));
        File src = signUp.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("src/main/java/Screenshots2/signUp.png/"));


        driver.quit();


    }
}
