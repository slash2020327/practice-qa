package com.solvd.practiceqa;

import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.solvd.practiceqa.util.CryptoUtil;
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
        String decryptedEmail = TestDataService.getValue("email");
        String decryptedPass = TestDataService.getValue("password");
        String email = CryptoUtil.decryptValue(decryptedEmail);
        String pass = CryptoUtil.decryptValue(decryptedPass);
        L10N.assertAll();

        AccountPageBase accountPage = loginService.login(email, pass);
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");
    }
}
