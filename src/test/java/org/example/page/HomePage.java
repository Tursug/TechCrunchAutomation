package org.example.page;

import org.example.base.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.constants.ConstantsHomePage.*;

public class HomePage extends BaseMethods {

    public List<WebElement> latestNews;

    public HomePage(WebDriver driver){super(driver);}

    public HomePage openHomePage(){
        navigateToUrl("https://techcrunch.com/");
        return this;
    }

    public HomePage setLatestNews() {
        this.latestNews = newsList();
        return this;
    }

    public boolean checkAuthor(){
        for(WebElement element : latestNews) {
            // System.out.println(element.findElement(AUTHORS).getText());
            if (element.findElement(AUTHORS).getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public boolean checkImage(){
        for(WebElement element : latestNews) {
            // System.out.println(element.findElement(IMAGE).getAttribute("src")+" : " +element.findElement(IMAGE).isDisplayed());
            if (!element.findElement(IMAGE).isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public NewsPage clickFirstNews(){
        click(latestNews.get(0));
        return callNewsPage();
    }

}
