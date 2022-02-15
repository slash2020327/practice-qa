package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class,'logo')]")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//input[contains(@class,'search')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//a[contains(@class,'bag')]")
    private ExtendedWebElement bagButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public ExtendedWebElement getBagButton() {
        return bagButton;
    }
}