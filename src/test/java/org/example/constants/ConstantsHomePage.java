package org.example.constants;

import org.openqa.selenium.By;

public class ConstantsHomePage extends ConstantsNewsPage {

    public static final By NEWS = By.cssSelector("article.post-block");

    public static final By AUTHORS = By.cssSelector("span.river-byline__authors");

    public static final By IMAGE = By.cssSelector("img");

}
