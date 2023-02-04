package com.qa.CRM.pages.ScreenshotTypes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SectionScreenshot {
    static WebDriver driver;
    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.w3schools.com/java/java_files.asp");


        WebElement webTable = driver.findElement(By.className("w3-responsive"));
        File src = webTable.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("src/main/java/Screenshots3/webTable.png/"));


        driver.quit();

    }
}
