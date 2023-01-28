package com.qa.CRM.tests;

import com.qa.CRM.pages.base.BaseTest;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ExcelUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTests extends BaseTest {

    @BeforeClass
    public void registrationPageSetUp(){
        registerPage = loginPage.isSignupLinkClick();
    }
    @DataProvider
    public Object[][] getRegisterData(){
        Object data[][] = ExcelUtil.getTestData(Constants.EXCEL_FILE_SHEET);
        return data;
    }


    @Test(dataProvider = "getRegisterData" )
    public void registrationSetTest(String firstname, String lastname, String email, String username, String password){
        registerPage.accountRegistration(firstname,lastname,email,username,password);
    }

}
