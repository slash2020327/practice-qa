package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductItemBase extends AbstractUIObject {

    public ProductItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductPageBase clickProduct();

    public abstract String getTitleText();
}
