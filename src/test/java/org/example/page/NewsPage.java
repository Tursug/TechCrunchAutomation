package org.example.page;

import org.example.base.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.example.constants.ConstantsNewsPage.LINK;

public class NewsPage extends BaseMethods {

    public NewsPage(WebDriver driver){
        super(driver);
    }

    public Boolean isBrowserTitleSameWithNewsTitle(){
        // System.out.println("BrowserTitle : " + getBrowserTitle());
        // System.out.println("NewsTitle : " + getNewsTitle());
        return getBrowserTitle().contains(getNewsTitle());
    }

    public Boolean linksWithinTheNewsContent(){
        ArrayList<String> links = new ArrayList<>();

        for (WebElement element : newsContent().findElements(LINK)){
            // System.out.println(element.getAttribute("href"));
            links.add(element.getAttribute("href"));
        }

        return !links.isEmpty();
    }



}
