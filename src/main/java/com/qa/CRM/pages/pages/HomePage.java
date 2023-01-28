package com.qa.CRM.pages.pages;

import com.qa.CRM.pages.base.BasePage;
import com.qa.CRM.pages.util.Constants;
import com.qa.CRM.pages.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    public WebDriver refer;
    private ElementUtil elementUtil;

    private By homeLink = By.xpath("//div[@id='navmenu']//ul//li/a[contains(@href, 'action=home')]");
    private By setUpIcon = By.xpath("//div[@class='noprint']//tr/td/a[contains(@href,'action=user')]");
    private By searchBar = By.xpath("//div[@class='noprint']//input[@src]");
    private By frameRefer = By.name("mainpanel");
    private By leftHeaders = By.xpath("//div[@id='navMenu']//li/a");
    private By contactsPage = By.linkText("CONTACTS");

    public HomePage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getHomePageTitle(){
//        return driver.getTitle();
        return elementUtil.doGetTittle(Constants.ALL_PAGE_TITLE, 10);
    }
    public WebDriver getFrame(){
        refer = driver.switchTo().frame("mainpanel");
        return refer;
    }

    public void getHomeLink() {
        elementUtil.switchToFrame();
        if (driver.findElement(homeLink).isDisplayed()) {
            elementUtil.doclick(homeLink);
            driver.navigate().back();
        }
    }

        public String isSetUpIconExist(){
            elementUtil.switchToFrame();
            if (driver.findElement(setUpIcon).isDisplayed()) {
                String setUpText = elementUtil.doGetText(setUpIcon);
                System.out.println(setUpText);
                return setUpText;
            }
            return null;
        }

        public void clickOnSearchBar() {
            elementUtil.switchToFrame();
            driver.findElement(searchBar).isDisplayed();
                elementUtil.doclickWait(searchBar, 10);
                driver.navigate().back();
        }
        public int getLeftHeaderCount() {
//            elementUtil.switchToFrame();
//            elementUtil.threadSleep(3000);
//            getFrame().findElements(leftHeaders);
                int count = elementUtil.getElementsCount(leftHeaders);
                System.out.println(count);
                return count;
        }
//        public List<String> getLeftHeaderList() {
//            List<String> leftHeaderList = new ArrayList<>();
//                List<WebElement> leftSectionList = getFrame().findElements(leftHeaders);
//                for (WebElement e : leftSectionList) {
//                    leftHeaderList.add(e.getText().trim());
//                    if(leftHeaderList.contains("Pipeline")){
//                        System.out.println(leftHeaderList+ "Pipeline is presented");
//                        break;
//                    }
//            }
//            return leftHeaderList;
//        }
        public ContactsPage clickOnContact () {
//            elementUtil.switchToFrame();
            elementUtil.doclickWait(contactsPage, 10);
            return new ContactsPage(driver);
        }
    }


