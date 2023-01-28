package com.qa.CRM.pages.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    public WebDriver init_driver(String browser){
        System.out.println("browser value is: " + browser);
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Please pass the correct browser value: " + browser);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
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



}
