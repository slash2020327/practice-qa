package com.solvd.practiceqa.web.components.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.ProductItemBase;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import com.solvd.practiceqa.web.pages.desktop.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidProductItem extends ProductItemBase {

    @FindBy(xpath = ".//p[contains(@class,'title')]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//img[contains(@class,'card')]")
    private ExtendedWebElement productPhoto;

    public AndroidProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ProductPageBase clickProduct() {
        productPhoto.click();
        return new ProductPage(getDriver());
    }

    @Override
    public String getTitleText() {
        return productTitle.getText();
    }
}
