package com.qa.CRM.pages.base;

import com.qa.CRM.pages.pages.*;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    public BasePage basepage;
    public Properties prop;
    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;
    public DeeptiContact deeptiContact;

    public ElementUtil elementUtil;
    public RegisterPage registerPage;




    @BeforeTest
    public void setUp(){
        basepage = new BasePage();
        prop = basepage.init_property();
        String browser = prop.getProperty("browser");
        driver = basepage.init_driver(browser);
//        loginPage = new LoginPage(driver);
        loginPage = (loginPage == null) ? new LoginPage(driver) : loginPage;  //if else

//        homePage = new HomePage(driver);
//        contactsPage = new ContactsPage(driver);
//        deeptiContact = new DeeptiContact(driver);
//        registerPage = new RegisterPage(driver);
        driver.get(prop.getProperty("url"));

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
