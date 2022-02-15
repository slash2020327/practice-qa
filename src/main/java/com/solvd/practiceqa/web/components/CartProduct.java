package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartProduct extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class, 'line-item') and contains(@class, 'title')]")
    private List<ExtendedWebElement> productTitle;

    @FindBy(xpath = ".//select[contains(@class, 'dropdown')]")
    private List<ExtendedWebElement> productAmount;

    @FindBy(xpath = ".//button[@class='gl-dropdown-custom__option']")
    private List<ExtendedWebElement> amountOptions;

    @FindBy(xpath = ".//button[contains(@data-auto-id, 'delete')]")
    private List<ExtendedWebElement> deleteButton;

    public CartProduct(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getProductTitle() {
        return productTitle;
    }

    public List<ExtendedWebElement> getProductAmount() {
        return productAmount;
    }

    public List<ExtendedWebElement> getAmountOptions() {
        return amountOptions;
    }

    public List<ExtendedWebElement> getDeleteButton() {
        return deleteButton;
    }
}
