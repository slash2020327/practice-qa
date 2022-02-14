package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public LoginService(WebDriver driver) {
        String loginEnd = TestDataService.getValue("login_end");
        String accountEnd = TestDataService.getValue("account_end");
        loginPage = new LoginPage(driver, loginEnd);
        accountPage = new AccountPage(driver, accountEnd);
    }

    public AccountPage login(String email, String pass) {
        loginPage.open();
        loginPage.insert(loginPage.getEmailField(), email);
        loginPage.insert(loginPage.getPasswordField(), pass);
        loginPage.click(loginPage.getLoginButton());
        return accountPage;
    }
}
