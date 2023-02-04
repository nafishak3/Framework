package com.qa.CRM.tests;

import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//@Listeners(ScreenShotUtil.class)
public class ContactsPageTests extends BaseTest {

    @BeforeClass
    public void contactsPageSetUp() {
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    SoftAssert softAssert = new SoftAssert();

   @Test(priority = 1)
    public void getTitle(){
       Assert.assertEquals(contactsPage.getHomePageTitle(), Constants.ALL_PAGE_TITLE);
   }
    @Test(priority = 2)
    public void clickOnContactsTest(){
//        Assert.assertEquals(homePage.clickOnContact(), Constants.HOME_PAGE_CONTACTS);
        homePage.getFrame();
        homePage.clickOnContact();
    }

    @Test(priority = 4)
    public void contactNameTest(){
        Assert.assertEquals(contactsPage.getContactName(), true );
    }

    @Test(priority = 5)
    public void clickOnContactDeeptiTest(){
        contactsPage.clickOnContantName();
    }


    }


