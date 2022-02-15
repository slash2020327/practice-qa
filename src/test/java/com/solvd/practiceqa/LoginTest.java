package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.service.LoginService;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    private LoginService loginService;

    @BeforeClass
    public void before() {
        loginService = new LoginService(getDriver());
    }

    @Test
    public void loginTest() {
        String email = TestDataService.getValue("email");
        String pass = TestDataService.getValue("password");
        AccountPage accountPage = loginService.login(email, pass);
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");
    }
}
