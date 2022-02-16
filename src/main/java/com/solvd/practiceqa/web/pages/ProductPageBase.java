package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase chooseSize(String size);

    public abstract String getProductTitleText();

    public abstract CartPageBase addProductToBag(String size);
}
