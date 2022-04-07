package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @Localized
    @FindBy(xpath = "//div[2]/div[1]/h3")
    protected ExtendedWebElement title;

    @FindBy(xpath = "//input[@id='login-email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordField;

    @Localized
    @FindBy(xpath = "//button[@type='submit']/span")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("base_url") + "/account-login");
    }

    @Override
    public LoginPage typeEmail(String email) {
        title.hover();
        emailField.type(email);
        return this;
    }

    @Override
    public LoginPage typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    @Override
    public AccountPage clickLoginButton() {
        loginButton.click();
        return new AccountPage(getDriver());
    }
}
