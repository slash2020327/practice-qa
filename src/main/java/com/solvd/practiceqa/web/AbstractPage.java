package com.solvd.practiceqa.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage extends Page {

    protected final WebDriver driver;
    protected String url;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
