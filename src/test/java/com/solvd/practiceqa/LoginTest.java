package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.LoginService;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    private static LoginService loginService;

    @BeforeClass
    public void before() {
        loginService = new LoginService(driver);
    }

    @Test public void loginTest() {
        String email = ConfigService.getValue("email");
        String pass = ConfigService.getValue("password");
        AccountPage accountPage = loginService.login(email, pass);
        WaitUtil.waitVisibility(driver, accountPage.getTitle());
        Assert.assertTrue(accountPage.getTitle().isDisplayed(), "Account page is not opened");
    }
}
