package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.util.WaitUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage extends Page {


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

    public void open() {
        driver.get(url);
        WaitUtil.sleep(3);
    }

    public void insert(WebElement inputField, String text) {
        inputField.sendKeys(text);
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
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
