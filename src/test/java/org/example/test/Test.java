package org.example.test;

import org.example.base.BaseDriver;
import org.example.page.HomePage;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

public class Test extends BaseDriver {

    HomePage homePage;

    @Before
    public void install(){
        homePage = new HomePage(getWebDriver());
        homePage = homePage.openHomePage().setLatestNews();
    }

    @org.junit.Test
    public void eachNewsHasAnAuthor(){
        assertTrue(homePage.checkAuthor());
    }

    @org.junit.Test
    public void eachNewsHasAnImage(){
        assertTrue(homePage.checkImage());
    }

    @org.junit.Test
    public void browserTitleSameWithNewsTitle(){
        assertTrue(homePage.clickFirstNews().isBrowserTitleSameWithNewsTitle());
    }

    @org.junit.Test
    public void linksWithinTheNewsContent(){
        assertTrue(homePage.clickFirstNews().linksWithinTheNewsContent());
    }
}
