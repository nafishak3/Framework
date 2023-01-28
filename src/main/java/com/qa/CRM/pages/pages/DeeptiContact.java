package com.qa.CRM.pages.pages;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeeptiContact extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private By company = By.xpath("(//div[@id='vSummary']//following-sibling::tr//tr)[5]//following-sibling::td/a");
    private By mobileNumber = By.xpath("(//div[@id='vSummary']//following-sibling::td//tr)[2]/td/span");


    public DeeptiContact(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public String getHomePageTitle(){
        return elementUtil.doGetTittle(Constants.ALL_PAGE_TITLE, 10);
    }
    public String getTheCompanyName(){
//        elementUtil.switchToFrame();
        elementUtil.getElement(company);
        String companyName = elementUtil.doGetText(company);
        System.out.println(companyName);
        return companyName;
    }
    public String getMobileNumber(){
        elementUtil.getElement(mobileNumber);
        String mobileNum= elementUtil.doGetText(mobileNumber);
        System.out.println(mobileNum);
        return mobileNum;
    }




}
