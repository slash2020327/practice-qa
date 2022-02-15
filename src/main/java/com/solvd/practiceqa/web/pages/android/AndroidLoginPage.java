package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected Header header;

    @FindBy(xpath = "//input[@id='login-email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement loginButton;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }
}
