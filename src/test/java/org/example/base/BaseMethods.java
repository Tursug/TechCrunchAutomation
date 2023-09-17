package org.example.base;

import org.example.page.NewsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.constants.ConstantsHomePage.NEWS;
import static org.example.constants.ConstantsNewsPage.CONTENT;
import static org.example.constants.ConstantsNewsPage.TITLE;

public class BaseMethods {

    WebDriver webDriver;

    WebDriverWait webDriverWait;

    public BaseMethods(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void navigateToUrl(String url){webDriver.navigate().to(url);}

    public void click(WebElement element){
        if(element!=null && !element.isDisplayed()){
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitElement(By by){ webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));}

    public String getBrowserTitle() {return webDriver.getTitle();}

    public String getNewsTitle() {
        waitElement(TITLE);
        return webDriver.findElement(TITLE).getText();
    }

    public WebElement newsContent(){
        waitElement(CONTENT);
        return webDriver.findElement(CONTENT);
    }

    public NewsPage callNewsPage(){
        return new NewsPage(webDriver);
    }

    public List<WebElement> newsList(){
        waitElement(NEWS);
        return webDriver.findElements(NEWS);
    }


}
