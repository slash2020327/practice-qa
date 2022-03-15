package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class AndroidLoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//input[@id='login-email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement loginButton;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/account-login");
    }

    @Override
    public AndroidLoginPage typeEmail(String email) {
        emailField.type(email);
        return this;
    }

    @Override
    public AndroidLoginPage typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    @Override
    public AndroidAccountPage clickLoginButton() {
        loginButton.click();
        return new AndroidAccountPage(getDriver());
    }
}
