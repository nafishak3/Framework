package com.qa.CRM.pages.base;

import com.aventstack.extentreports.utils.FileUtil;
import com.qa.CRM.pages.util.optionManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    /**
     * This method is used to initlize the browser on the bases of given browser
     * @para browser
     * @return This returns webDriver driver
      */
    public WebDriver driver;
    public Properties prop;
    public optionManager Optionmanager;
    public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver init_driver(String browser){
        System.out.println("browser value is: " + browser);
        Optionmanager = new optionManager(prop);

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
            tlDriver.set(new ChromeDriver(Optionmanager.getChromeOptions()));
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            tlDriver.set(new FirefoxDriver(Optionmanager.getFirefoxOptions()));
        }
        else {
            System.out.println("Please pass the correct browser value: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return getDriver();
    }
    /**
     * getDriver using ThreadLocal
     * synchronized means it will call one thread at a time
     */

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
    /**
     * This method is used to load the properties from config.properties file
     * @return it reruns properties prop reference
     */

    public Properties init_property(){
        prop = new Properties(); // to get properties of files //This is part of collection API
        try {
            FileInputStream ip = new FileInputStream("src/main/java/com/qa/CRM/pages/config/config.properties"); // connect it to config file
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    /**
     * This method is used to take the screenshot
     * it will return a path of screenshot
     */
    public String getScreenshot(){
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }



}
