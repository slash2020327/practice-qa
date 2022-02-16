package com.solvd.practiceqa.web.pages.android;

import com.solvd.practiceqa.web.components.android.AndroidFooter;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.pages.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends HomePageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//footer")
    protected AndroidFooter footer;

    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }
}
