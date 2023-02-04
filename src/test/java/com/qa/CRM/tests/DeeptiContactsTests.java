package com.qa.CRM.tests;

import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(ScreenShotUtil.class)
public class DeeptiContactsTests extends BaseTest {

    @BeforeClass
    public void DeeptiContactsPagesetUp(){
        homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void getThePageTitle(){
        Assert.assertEquals(deeptiContact.getHomePageTitle(), Constants.ALL_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void clickOnContactsTest(){
        homePage.getFrame();
        homePage.clickOnContact();
    }
    @Test(priority = 3)
    public void getDeeptiContactsTest(){
        contactsPage.clickOnContantName();
    }
    @Test(priority = 4)
    public void getCompanyNameTest(){
        Assert.assertEquals(deeptiContact.getTheCompanyName(), Constants.DEEPTI_COMPANY_NAME);
    }
    @Test(priority = 5)
    public void getMobileNameTest(){
        Assert.assertEquals(deeptiContact.getMobileNumber(), Constants.DEEPTI_MOBILE_NUMBER);

    }
}
