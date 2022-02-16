package com.solvd.practiceqa.web.service;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.solvd.practiceqa.web.pages.AccountPageBase;
import com.solvd.practiceqa.web.pages.LoginPageBase;

public class LoginService implements ICustomTypePageFactory {

    private final LoginPageBase loginPage;
    private final AccountPageBase accountPage;

    public LoginService() {
        this.loginPage = initPage(getDriver(), LoginPageBase.class);
        this.accountPage = initPage(getDriver(), AccountPageBase.class);
    }

    public AccountPageBase login(String email, String pass) {
        loginPage.open();
        loginPage.typeEmail(email);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        return accountPage;
    }
}
