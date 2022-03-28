package com.solvd.practiceqa.web.components.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.ProductItemBase;
import com.solvd.practiceqa.web.pages.desktop.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends ProductItemBase {

    @FindBy(xpath = ".//p[contains(@class,'title')]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//img[contains(@class,'card')]")
    private ExtendedWebElement productPhoto;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTitleText() {
        return productTitle.getText();
    }

    @Override
    public ProductPage clickProduct() {
        productPhoto.click();
        return new ProductPage(getDriver());
    }
}
