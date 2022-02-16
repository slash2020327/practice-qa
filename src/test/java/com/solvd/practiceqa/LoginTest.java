package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPageBase;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    private static LoginPageBase loginPage;
    private static AccountPageBase accountPage;

    @BeforeClass
    public void beforeLogin() {
        loginPage = initPage(getDriver(), LoginPageBase.class);
        accountPage = initPage(getDriver(), AccountPageBase.class);
    }

    @Test
    public void loginTest() {
        String email = TestDataService.getValue("email");
        String pass = TestDataService.getValue("password");
        loginPage.open();
        loginPage.typeEmail(email);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");
    }
}
