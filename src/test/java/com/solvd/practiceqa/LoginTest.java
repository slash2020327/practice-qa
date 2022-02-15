package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.service.LoginService;
import com.solvd.practiceqa.web.service.TestDataService;
import com.solvd.practiceqa.web.util.DriverUtil;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    private static LoginService loginService;

    @BeforeClass
    public void before() {
        WebDriver driver = DriverUtil.getDriver("login");
        loginService = new LoginService(driver);
    }

    @Test public void loginTest() {
        WebDriver driver = DriverUtil.getDriver("login");
        String email = TestDataService.getValue("email");
        String pass = TestDataService.getValue("password");
        AccountPage accountPage = loginService.login(email, pass);
        WaitUtil.waitVisibility(driver, accountPage.getTitle());
        Assert.assertTrue(accountPage.getTitle().isDisplayed(), "Account page is not opened");
    }
}
