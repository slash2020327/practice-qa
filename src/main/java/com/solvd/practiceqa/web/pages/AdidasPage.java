package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.practiceqa.web.components.Footer;
import com.solvd.practiceqa.web.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AdidasPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @FindBy(xpath = "//footer")
    protected Footer footer;

    public AdidasPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
