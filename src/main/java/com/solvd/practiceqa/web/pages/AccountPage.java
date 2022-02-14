package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class, heading)]")
    private WebElement title;

    @FindBy(xpath = "//button[@role='tab']")
    private List<WebElement> accountLinks;

    public AccountPage(WebDriver driver) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL) + "/my-account";
        setUrl(pageUrl);
    }

    public AccountPage(WebDriver driver, String path) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL);
        setUrl(pageUrl + path);
    }

    public WebElement getTitle() {
        return title;
    }

    public List<WebElement> getAccountLinks() {
        return accountLinks;
    }
}
