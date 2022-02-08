package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public LoginService(WebDriver driver) {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    public AccountPage login(String email, String pass) {
        loginPage.open();
        AbstractPage.sleep(4);
        loginPage.printEmail(email);
        loginPage.printPassword(pass);
        loginPage.getLoginButton().click();
        return accountPage;
    }
}
