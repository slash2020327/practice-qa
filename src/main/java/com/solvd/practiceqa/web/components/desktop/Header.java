package com.solvd.practiceqa.web.components.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.HeaderBase;
import com.solvd.practiceqa.web.pages.desktop.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends HeaderBase {

    @FindBy(xpath = ".//a[contains(@class,'logo')]")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//input[contains(@class,'search')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//a[contains(@class,'bag')]")
    private ExtendedWebElement bagButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public SearchPage inputSearchText(String text) {
        searchField.type(text);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage(getDriver());
    }

    @Override
    public void clickBagButton() {
        bagButton.click();
    }
}
