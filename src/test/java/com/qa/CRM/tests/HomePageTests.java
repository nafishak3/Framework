package com.qa.CRM.tests;

import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners (ScreenShotUtil.class)
public class HomePageTests extends BaseTest {

    @BeforeClass
    public void homepageSetUp(){
        homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void homePageTitleTest(){
        String title = homePage.getHomePageTitle();
        System.out.println("This is my homePage title: " + title);
        Assert.assertEquals(title, Constants.ALL_PAGE_TITLE);
    }
    @Test(priority = 2)
    public void verifyHomePageHeaderTest(){
       homePage.getHomeLink();
    }
    @Test(priority = 3)
    public void verifySetUpIconTest(){
        Assert.assertEquals(homePage.isSetUpIconExist().trim(),Constants.HOME_PAGE_SETUPICON.trim());
    }
//    @Test(priority = 4)
//    public void verifySearchBarTest(){
//        homePage.clickOnSearchBar();
//    }
    @Test(priority = 4)
    public void verifyTheCountOfHeaderTest(){
        Assert.assertEquals(homePage.getLeftHeaderCount(),Constants.LEFT_PAGE_HEADER);
    }
//    @Test(priority = 5)
//    public void verifyTheListOfHeaderTest(){
//        Assert.assertEquals(homePage.getLeftHeaderList(), Constants.LIST_OF_HEADERS());
//    }

    @Test(priority = 6)
    public void clickOnContactsTest() {
       homePage.clickOnContact();
    }

}
