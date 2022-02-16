package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SearchPageBase inputSearchText(String text);

    public abstract void clickBagButton();
}
