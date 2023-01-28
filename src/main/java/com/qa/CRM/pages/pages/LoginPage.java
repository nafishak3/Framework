package com.qa.CRM.pages.pages;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;


// 1. By locators: Object repository
    private By emailID = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//input[@class ='btn btn-small']");
    private By signUpLink = By.linkText("Sign Up");
    private By signUpLinkClick = By.xpath("(//div[@id ='navbar-collapse']//ul/li/a)[2]");
    private By pageTitle = By.xpath("//a[@class='navbar-brand']//img");


// 2. Constructor of the page class:
    public LoginPage(WebDriver driver){
        this.driver = driver; //this constructor reruns the private driver.
        elementUtil = new ElementUtil(driver); //after creating object fot elementUtil, I will be changing all my methods
    }

// 3. page actions:features(behavior) of the page in the form of methods
    public String getLoginPageTitle(){
//       return driver.getTitle();
        return elementUtil.doGetTittle(Constants.LOGIN_PAGE_TITLE, 10);
    }
    public boolean isSignupLinkExist(){
//        return driver.findElement(signUpLink).isDisplayed();
        return elementUtil.doIsDisplayed(signUpLink);
    }
    public RegisterPage isSignupLinkClick(){
//        return driver.findElement(signUpLink).isDisplayed();
        elementUtil.doclick(signUpLinkClick);
        return new RegisterPage(driver);
    }

    public HomePage doLogin(String username, String pass){
        System.out.println("Login with: " + username + " and " + pass);
//        driver.findElement(emailID).sendKeys(username);
//        driver.findElement(password).sendKeys(pass);
//        driver.findElement(loginButton).click();
        elementUtil.doSendKeys(emailID, username);
        elementUtil.doSendKeys(password, pass);
        elementUtil.doclick(loginButton);
        return new HomePage(driver);
    }
    public boolean crmPageHeader(){
//        return driver.findElement(pageTitle).isDisplayed();
        return elementUtil.doIsDisplayed(pageTitle);
    }






}
