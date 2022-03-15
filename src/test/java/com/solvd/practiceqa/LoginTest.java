package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPageBase;
import com.solvd.practiceqa.web.service.LoginService;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    private static LoginService loginService;

    @BeforeClass
    public void beforeLogin() {
        loginService = new LoginService();
    }

    @Test
    public void loginTest() {
        String email = TestDataService.getValue("email");
        String pass = TestDataService.getValue("password");
        AccountPageBase accountPage = loginService.login(email, pass);
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");
    }
}
