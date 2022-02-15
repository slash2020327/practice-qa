package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class CartProductBase extends AbstractUIObject {

    public CartProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
