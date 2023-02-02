package com.qa.CRM.pages.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class optionManager {

    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;

    public optionManager(Properties prop){
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions(){
        co = new ChromeOptions();

        if (prop.getProperty("headless").trim().equals("true"))co.addArguments("--headless");

        if (prop.getProperty("incognito").trim().equals("true")) co.addArguments("--incognito");
        return co;
    }

    public FirefoxOptions getFirefoxOptions(){
        fo = new FirefoxOptions();

        if (prop.getProperty("headless").trim().equals("true"))fo.addArguments("--headless");

        if(prop.getProperty("incognito").trim().equals("true"))fo.addArguments("--incognito");
        return fo;
    }
}
