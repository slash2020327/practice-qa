package com.solvd.practiceqa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AbstractPage extends Page {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected final WebDriver driver;
    protected String url;

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

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }
}
