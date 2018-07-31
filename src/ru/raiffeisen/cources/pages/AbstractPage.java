package ru.raiffeisen.cources.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {
    protected WebDriver driver;
    public abstract void init(final WebDriver webDriver);

    public String getTitle(){
        return driver.getTitle();
    }
}
