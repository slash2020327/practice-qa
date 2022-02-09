package com.solvd.practiceqa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class AbstractPage extends Page {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected final WebDriver driver;
    protected String url;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    protected WebElement logo;

    @FindBy(xpath = "//input[contains(@class,'search')]")
    protected WebElement searchField;

    @FindBy(xpath = "//a[contains(@class,'bag')]")
    protected WebElement bagButton;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LOGGER.warn("Thread was interrupted");
        }
    }

    public void open() {
        driver.get(url);
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    public void logoClick() {
        logo.click();
    }

    public void goToBag() {
        bagButton.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getBagButton() {
        return bagButton;
    }
}
