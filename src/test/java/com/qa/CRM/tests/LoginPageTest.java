package com.qa.CRM.tests;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners (ScreenShotUtil.class)

public class LoginPageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert(); //This is a class, that is used to verify multiple assertions together.
    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){
        String title = loginPage.getLoginPageTitle();
        System.out.println("Login page title is: " + title);
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }
    @Test(priority = 2)
    public void verifySignupLinkTest(){
       softAssert.assertTrue(loginPage.isSignupLinkExist());
        softAssert.assertTrue(loginPage.crmPageHeader());
        softAssert.assertAll(); //This will return which test assertion works or doesnt work
    }
    @Test(priority = 3)
    public void loginTest(){
        loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }




}
