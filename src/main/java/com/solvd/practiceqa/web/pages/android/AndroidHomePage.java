package com.solvd.practiceqa.web.pages.android;

import com.solvd.practiceqa.web.components.desktop.Footer;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends HomePageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected Header header;

    @FindBy(xpath = "//footer")
    protected Footer footer;

    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
