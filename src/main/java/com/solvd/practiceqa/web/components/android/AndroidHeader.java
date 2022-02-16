package com.solvd.practiceqa.web.components.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.HeaderBase;
import com.solvd.practiceqa.web.pages.android.AndroidSearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidHeader extends HeaderBase {

    @FindBy(xpath = ".//a[contains(@class,'logo')]")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//div[contains(@class,'right')]//button[contains(@class, 'nav')]")
    private ExtendedWebElement searchIcon;

    @FindBy(xpath = "//input[contains(@class,'search')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//a[contains(@class,'bag')]")
    private ExtendedWebElement bagButton;

    public AndroidHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AndroidSearchPage inputSearchText(String text) {
        searchIcon.click();
        searchField.type(text);
        searchField.sendKeys(Keys.ENTER);
        return new AndroidSearchPage(getDriver());
    }

    @Override
    public void clickBagButton() {
        bagButton.click();
    }
}
