package com.solvd.practiceqa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends Page {

    private static final String URL = "https://www.adidas.com/us/my-account";

    @FindBy(xpath = "//h1[contains(@class, heading)]")
    private WebElement title;

    @FindBy(xpath = "//button[@role='tab']")
    private List<WebElement> accountLinks;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

    public List<WebElement> getAccountLinks() {
        return accountLinks;
    }
}
