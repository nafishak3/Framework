package com.qa.CRM.pages.pages;

import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BaseTest {


    private By selectOption = By.id("payment_plan_id");
    private By firstName = By.name("first_name");
    private By lastName = By.name("surname");
    private By emailID = By.name("email");
    private By emailConfirm = By.name("email_confirm");
    private By userName = By.name("username");
    private By pass = By.name("password");
    private By passConfirm = By.name("passwordconfirm");
    private By checkbox = By.xpath("//div[@class ='checkbox']//input");
    private By submit = By.xpath("//div[@class ='myButton']/button");

    private ElementUtil elementUtil;



    public RegisterPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public void accountRegistration(String firstname, String lastname, String email, String username, String password) {
        elementUtil.doDropDownSelectByVisualText(selectOption, "Free Edition");
        elementUtil.doSendKeys(this.firstName, firstname);
        elementUtil.doSendKeys(this.lastName, lastname);
        elementUtil.doSendKeys(this.emailID, email);
        elementUtil.doSendKeys(this.emailConfirm, email);
        elementUtil.doSendKeys(this.userName, username);
        elementUtil.doSendKeys(this.pass, password);
        elementUtil.doSendKeys(this.passConfirm, password);

        elementUtil.doclick(this.checkbox);
        elementUtil.doclick(submit);
    }

}
