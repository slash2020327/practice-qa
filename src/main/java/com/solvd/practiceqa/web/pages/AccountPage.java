package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends AdidasPage {

    @FindBy(xpath = "//h1[contains(@class, heading)]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@role='tab']")
    private List<ExtendedWebElement> accountLinks;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/my-account");
    }

    public ExtendedWebElement getPageTitle() {
        return title;
    }

    public List<ExtendedWebElement> getAccountLinks() {
        return accountLinks;
    }
}
