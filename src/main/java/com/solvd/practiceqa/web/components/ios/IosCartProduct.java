package com.solvd.practiceqa.web.components.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.CartProductBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IosCartProduct extends CartProductBase {

    @FindBy(xpath = ".//a[contains(@class, 'line-item') and contains(@class, 'title')]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//select[contains(@class, 'dropdown')]")
    private Select productAmount;

    @FindBy(xpath = ".//button[contains(@data-auto-id, 'delete')]")
    private ExtendedWebElement deleteButton;

    public IosCartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductTitleText() {
        return productTitle.getText();
    }
}
