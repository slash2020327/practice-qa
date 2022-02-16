package com.solvd.practiceqa.web.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterBase extends AbstractUIObject {

    public FooterBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
