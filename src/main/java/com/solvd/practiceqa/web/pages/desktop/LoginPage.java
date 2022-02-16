package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @FindBy(xpath = "//input[@id='login-email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/account-login");
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }
}
