package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public LoginService(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.accountPage = new AccountPage(driver);
    }

    public AccountPage login(String email, String pass) {
        loginPage.open();
        loginPage.getEmailField().type(email);
        loginPage.getPasswordField().type(pass);
        loginPage.getLoginButton().click();
        return accountPage;
    }
}
