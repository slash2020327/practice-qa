package com.solvd.practiceqa.web.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.solvd.practiceqa.web.components.ios.IosHeader;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class IosLoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected IosHeader header;

    @FindBy(xpath = "//input[@id='login-email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement loginButton;

    public IosLoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/account-login");
    }

    @Override
    public IosLoginPage typeEmail(String email) {
        emailField.type(email);
        return this;
    }

    @Override
    public IosLoginPage typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    @Override
    public IosAccountPage clickLoginButton() {
        loginButton.click();
        return new IosAccountPage(getDriver());
    }
}