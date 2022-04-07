package com.solvd.practiceqa;

import com.solvd.practiceqa.util.CryptoUtil;
import com.solvd.practiceqa.web.pages.AccountPageBase;
import com.solvd.practiceqa.web.pages.LoginPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Image;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class SikuliTest extends AbstractTest {

    private LoginPageBase loginPage;
    private AccountPageBase accountPage;
    private Screen sc;
    private String path;

    @BeforeMethod
    public void beforeClass() {
        this.loginPage = initPage(getDriver(), LoginPageBase.class);
        this.accountPage = initPage(getDriver(), AccountPageBase.class);
        this.sc = new Screen();
        this.path = "src/test/resources/sikuli";
    }

    @Test
    public void loginTest() throws FindFailed {
        String decryptedEmail = TestDataService.getValue("email");
        String decryptedPass = TestDataService.getValue("password");
        String email = CryptoUtil.decryptValue(decryptedEmail);
        String pass = CryptoUtil.decryptValue(decryptedPass);

        Image passField = Image.create(new File(path + "/password.png"));
        Image loginButton = Image.create(new File(path + "/button.png"));

        loginPage.open();
        sc.type(email);
        sc.click(passField);
        sc.type(pass);
        sc.click(loginButton);
        Assert.assertTrue(accountPage.isPageOpened());
    }
}
