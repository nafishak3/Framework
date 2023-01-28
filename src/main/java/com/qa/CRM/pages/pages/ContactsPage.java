package com.qa.CRM.pages.pages;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {
    private WebDriver driver;
    private WebDriver refer;
    private ElementUtil elementUtil;

    private By frameRefer = By.name("mainpanel");
    private By deeptiContacts = By.xpath("//a[contains(text(),'deepti gupta')]");




    public ContactsPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public String getHomePageTitle(){
        return elementUtil.doGetTittle(Constants.ALL_PAGE_TITLE, 10);
    }


    public WebDriver getFrame(){
        refer = driver.switchTo().frame(driver.findElement(frameRefer));
        return refer;
    }
    public boolean getContactName(){
       elementUtil.doIsDisplayed(deeptiContacts);
       return true;
    }
    public DeeptiContact clickOnContantName(){
        elementUtil.isElementExist(deeptiContacts);
        elementUtil.doclickWait(deeptiContacts, 5);
        return new DeeptiContact(driver);
    }

//    public ContactsPage getCompanyName(){
//        if(elementUtil.doIsDisplayed(naveenUsername)){
//            elementUtil.doclick(naveenUsername);
//        }
//        return new ContactsPage(driver);
//    }





}
