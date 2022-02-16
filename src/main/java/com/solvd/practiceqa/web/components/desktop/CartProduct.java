package com.solvd.practiceqa.web.components.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.CartProductBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProduct extends CartProductBase {

    @FindBy(xpath = ".//a[contains(@class, 'line-item') and contains(@class, 'title')]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//select[contains(@class, 'dropdown')]")
    private ExtendedWebElement productAmount;

    @FindBy(xpath = ".//button[@class='gl-dropdown-custom__option']")
    private ExtendedWebElement amountOptions;

    @FindBy(xpath = ".//button[contains(@data-auto-id, 'delete')]")
    private ExtendedWebElement deleteButton;

    public CartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductTitleText() {
        return productTitle.getText();
    }
}
