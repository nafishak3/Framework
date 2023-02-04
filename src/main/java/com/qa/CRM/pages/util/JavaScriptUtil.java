package com.qa.CRM.pages.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

        private WebDriver driver;

    public JavaScriptUtil(WebDriver driver) {
            this.driver = driver;
        }

        public String getTittleByJS() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return document.title;").toString();
        }

        public void genarateAlert(String message) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('" + message + "')");
        }

        public String getPageInnerText() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return document.documentElement.innerText").toString();
        }

        public void refreshBrowserByJS() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("history.go(0)");
        }

        // this is least used unless selenium click executor or action class isn't working.
        // javaScript executor doesn't perform form end user experience so, it's better to use s or ac
        public void clickElementByJS(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }

        public void scrollPageDown() {            //Selenium doesn't provide scroll DOWN so JS provides scroll method
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }

        public void scrollPageDown(String height) {  // It will scroll to specific height
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, '" + height + "' )");

        }
        public void scrollPageUp(){                 //Selenium doesn't provide scroll UP so JS provides scroll method
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        }
        public void scrollIntoView(WebElement element){      //This scrolls through specific element not provided in selenium
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)",element);
        }

        public void drawBorder(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element); // for util purpose
        }

        public void flash(WebElement element) { //2 highlight
            String bgColor = element.getCssValue("backgroundColor");
            for (int i = 0; i < 15; i++) {
                changeColor("rgb(0,200,0)", element);
                changeColor(bgColor, element);
            }
        }

        public void changeColor(String color, WebElement element) { //3
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", element);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
        public void sendKeysUsingWithId(String id, String value){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('"+id+"').value = '"+value+"'");
        }


    }


