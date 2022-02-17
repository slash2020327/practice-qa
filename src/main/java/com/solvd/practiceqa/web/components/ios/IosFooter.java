package com.solvd.practiceqa.web.components.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.FooterBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IosFooter extends FooterBase {

    @FindBy(xpath = ".//li")
    private List<ExtendedWebElement> privacyLinks;

    public IosFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}