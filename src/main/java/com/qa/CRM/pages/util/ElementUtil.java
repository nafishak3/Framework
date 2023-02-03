package com.qa.CRM.pages.util;

import com.qa.CRM.pages.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    public WebDriver frame;
    private JavaScriptUtil jsUtil;


    public ElementUtil(WebDriver driver){
        this.driver = driver;
        jsUtil = new JavaScriptUtil(driver);
    }

    public  WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        if (BasePage.highlight.equals("true")){
            jsUtil.flash(element);
        }
        return element;
    }
    public WebDriver switchToFrame(){
        WebDriver target = driver.switchTo().frame("mainpanel");
        return target;
    }
    public void threadSleep(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public  List<WebElement> getElements (By locator){     // get elements
        return driver.findElements(locator);
    }

    public  WebElement getElement(String locatorType, String locatorValue){
        return driver.findElement (getby(locatorType, locatorValue));
    }

    public  void doSendKeys (By Locator, String value){
        getElement(Locator).sendKeys(value);
    }
    public  void doSendKeys (String locatorType, String locatorValue, String value){
        getElement(locatorType,locatorValue).sendKeys(value);
    }



    public By getby (String locatorType, String locatorValue){
        By locator = null;

        switch (locatorType.toLowerCase()){
            case "id":
                locator = By.id(locatorValue);
                break;
            case "name":
                locator = By.name(locatorValue);
                break;
            case "classname":
                locator = By.className(locatorValue);
                break;
            case "Xpath":
                locator = By.xpath(locatorValue);
                break;
            case "cssSelector":
                locator = By.cssSelector(locatorValue);
                break;
            case "linktext":
                locator = By.linkText(locatorValue);
                break;
            default:
                System.out.println("please pass the right locator type and value....");
                break;
        }
        return locator;
    }

    public void doclick (By locator){
        getElement(locator).click();
    }
    public void doclickWait (By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        getElement(locator).click();
    }
    public  void doclick (String locatorType, String locatorValue){
        getElement(locatorType,locatorValue).click();
    }

    public  String doGetText (By locator){                 // to get the text
        return getElement(locator).getText();
    }
    public  String getAttributeValue (By locator, String attributeName){  // get the attribute value
        String attrValue = getElement(locator).getAttribute(attributeName);
        System.out.println(attrValue);
        return attrValue;
    }
    public boolean doIsDisplayed (By locator){
        return getElement(locator).isDisplayed();
    }
    public  boolean isElementExist(By locator) {
        int elementCount = getElementsCount(locator);
        System.out.println("total elements count " + elementCount);
        if (elementCount >= 1) {
            System.out.println("element is found......" + locator);
            return true;
        } else {
            System.out.println("element is not found " + locator);
            return false;
        }
    }
    public  List<String> getElementsTextList (By locator){   // capture the text
        List <WebElement> eleList = getElements(locator);
        List <String> eleTextList = new ArrayList<String>();
        for (WebElement e : eleList){
            String eleText = e.getText();
            if (!eleText.isEmpty()){
                eleTextList.add(eleText);
            }
        }
        return eleTextList;
    }

    public  int getElementsCount (By locator){       //get the total count
        return getElements(locator).size();
    }

    public  List<String> getAttributeList (By locator, String attributeName){  // getting images util
        List <WebElement> elementList = getElements(locator);
        List <String> arryList = new ArrayList<String>();

        for (WebElement e:elementList) {
            String attrValue = e.getAttribute(attributeName);
            arryList.add(attrValue);
        }
        return arryList;
    }
    public  void printElementValue(List <String> eleList) {  // printing it on consoul
        for (String e : eleList) {
            System.out.println(e);
        }
    }
    /***********************************DROP Down Util ***************************************************************/
    public  void doDropDownSelectByIndex (By locator, int index){  //1
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }
    public  void doDropDownSelectByVisualText(By locator, String text){  //2
        Select select= new Select(getElement(locator));
        select.selectByVisibleText(text);
    }
    public  void doDropDownSelectByValue (By locator, String value){  //3
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
    public void doSelectDropDownValue (By locator, String value){
        Select select = new Select(getElement(locator));
        List<WebElement> optionList = select.getOptions();
        for (WebElement e : optionList){
            String text = e.getText();
            System.out.println(text);
            if (text.equals(value)){
                e.click();
                break;
            }
        }
    }
    // Difference is on Top we are using select class and down here we aren't using select class
    public  void selectDropDownValueWithoutSelect (By locator, String value){
        List<WebElement> optionsList = getElements(locator);
        System.out.println(optionsList.size());
        for (WebElement e : optionsList){
            String text = e.getText();
            if (text.equals(value)){
                e.click();
                break;
            }
        }
    }
    /*********************************** Links Util ***************************************************************/
    public List <String> getLinksTextList(By locator){
        List<WebElement> linksList =  getElements(locator);
        List <String> linksTextList =  new ArrayList<String>();
        System.out.println(linksList.size());

        for ( WebElement e : linksList){
            String text= e.getText().trim();
            linksTextList.add(text);
        }
        return linksTextList;
    }
    public void clickOnElementFromListSection(By locator, String value){
        List<WebElement> lanList =  getElements(locator);
        System.out.println(lanList.size());

        for ( WebElement e : lanList){
            String text= e.getText().trim();
            System.out.println(text);
            if (text.equals(value)){
                e.click();
                break;
            }
        }
    }

//    *********************** WebTable Util ***************************
    public  void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath){
        int rowcount = getElements(rowLocator).size();
        int colcount = getElements(colLocator).size();
        for (int row = 2; row<=rowcount; row++){
            for (int col=1; col<=colcount; col++){
                String xpath =  beforeXpath+ row + afterXpath + col + "]";
                String text = doGetText(By.xpath(xpath));
                System.out.print(text + " | ");
            }
            System.out.println();

        }
    }
//    **************************************** Actions util ************************************
    public void doMoveToElement(By locator){
        Actions act = new Actions(driver);
        act.moveToElement(getElement(locator)).perform();
}
    public void doClickOnChildMenu (By parentMenuLocator , By childMenuLocator) throws InterruptedException {
        doMoveToElement(parentMenuLocator);
        Thread.sleep(3000);
        doclick(childMenuLocator);
    }
    public  void doActionSendKeys (By locator, String value){
        Actions act = new Actions(driver);
        act.sendKeys(getElement(locator), value).build().perform();
    }
    public  void doActionSendKeysOnActiveElement (By locator, String value){
        Actions act = new Actions(driver);
        act.click(getElement(locator)).sendKeys(value).build().perform();
    }
    public  void doActonClick(By locator){
        Actions act = new Actions(driver);
        act.click(getElement(locator)).build().perform();
    }
    public  void doActionMoveToElementClick (By locator){
        Actions act = new Actions(driver);
        act.moveToElement(getElement(locator)).click().build().perform();
    }

//    ******************************* WAIT util *************************************************

    public WebElement getElement(By locator, int timeOut){
        return doPresenceOfElementLocated(locator, timeOut);
    }
    public void doSendKeys(By locator, String value, int timeOut){
        doPresenceOfElementLocated(locator, timeOut).sendKeys(value);
    }
    public WebElement doPresenceOfElementLocated (By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement doPresenceOfElementLocated (By locator, int timeOut, long intervalTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement waitForElementToBeVisible (By locator, int timeOut, long intervalTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForElementToBeVisibleWithWebElement (By locator, int timeOut, long intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }
    public List <WebElement>  waitForElementsToBeVisible (By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public List <WebElement> waitForElementsToBeVisible (By locator, int timeOut, long intervalTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public List<String> getElementTextListWithWait(By locator, int timeout){
        List <WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
        List <String> eleTextList = new ArrayList<String>();
        for (WebElement e: eleList){
            String text = e.getText();
            eleTextList.add(text);
        }
        return eleTextList;
    }
    public boolean waitForURLToContains(String urlFraction, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
    public boolean waitForURLTOBE(String url, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.urlContains(url));
    }
    public String  doGetTittleWithFraction(String tittleFraction, int timeOut){
        if (waitForTitleContains(tittleFraction,timeOut)){
            return driver.getTitle();
        }
        return null;
    }
    public String  doGetTittle(String tittle, int timeOut){
        if (waitForTitleToBE(tittle,timeOut)){
            return driver.getTitle();
        }
        return null;
    }
    public  boolean waitForTitleContains(String tittleFraction, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.titleContains(tittleFraction));

    }
    public  boolean waitForTitleToBE(String tittle, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.titleIs(tittle));

    }
//    ******************************** Wait util for NON-WebElements (Alerts) ***********************************************************
    public Alert waitForAlert(int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    return wait.until(ExpectedConditions.alertIsPresent());
}
    public String getAlertText (int timeOut){
        return waitForAlert(timeOut).getText();
    }
    public void getAlertAccept (int timeOut){
        waitForAlert(timeOut).accept();
    }
    public void getAlertDismiss (int timeOut){
        waitForAlert(timeOut).dismiss();
    }
    public void enterAlertText (String text, int timeOut){
        waitForAlert(timeOut).sendKeys(text);
    }

//************************************ Wait Frame Util **************************************************
    public void waitForFrameByLocator(String frameLocator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(frameLocator)));
    }
    public void waitForFrameByIndex(int frameIndex, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }
    public void waitForFrameByNameOrID(String nameOrID, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
    }
    public void waitForFrameByElement(WebElement frameElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }
//    ************************ wait Click Element **********************************************
    public  void clickElementWhenReady(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public  void clickElementWhenReady(By locator, int timeOut, long intervalTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),  Duration.ofMillis(intervalTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
//    *********************** Explicit util********************************************************
    public WebElement waitForElementPresentUsingFluentWait(By locator, int timeOut, long intervelTime){  //Builder pattern
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(intervelTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage(Constants.ELEMENT_NOT_FOUND_ERROR_MESSG);

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement waitForElementUsingWebDriverWait(By locator, int timeOut,long intervelTime ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait
                .pollingEvery(Duration.ofSeconds(intervelTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage(Constants.ELEMENT_NOT_FOUND_ERROR_MESSG);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
//    ********************************* Custome Wait ***********************************************

    public WebElement reTryingElement(By locator, int timeOut){
        WebElement element = null;
        int attempts = 0;

        while (attempts < timeOut ){
            try {
                element = getElement(locator);
                break;
            }catch (NoSuchElementException e){
                System.out.println("element is not found: " + attempts + " :: " + locator);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            attempts++;
        }
        if (element == null){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("element is not found.... tried for : " + timeOut +  " with the intervel of : " + 500 + "ms");
            }

        }
        return element;
    }
    public WebElement reTryingElement(By locator, int timeOut, long intervelTime){
        WebElement element = null;
        int attempts = 0;

        while (attempts < timeOut ){
            try {
                element = getElement(locator);
                break;
            }catch (NoSuchElementException e){
                System.out.println("element is not found: " + attempts + " :: " + locator);
                try {
                    Thread.sleep(intervelTime);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            attempts++;
        }
        if (element == null){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("element is not found.... tried for : " + timeOut +  " with the intervel of : " + intervelTime + "ms");
            }

        }
        return element;
    }







//    OverLoaded methods
//1) WebElement getElement
//2) doClick
//3) doSendKeys
//4) reTryingElement



}
