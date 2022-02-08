package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.DriverService;
import com.solvd.practiceqa.web.service.LoginService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private static WebDriver driver;
    private static LoginService loginService;

    @BeforeTest public void before() {
        new ConfigService();
        driver = DriverService.driverInit();
        loginService = new LoginService(driver);
    }

    @Test public void loginTest() {
        String email = ConfigService.getValue("email");
        String pass = ConfigService.getValue("password");
        AccountPage accountPage = loginService.login(email, pass);
        AbstractPage.sleep(5);
        Assert.assertTrue(accountPage.getTitle().isDisplayed(), "Account page is not opened");
    }

    @AfterTest public void after() {
        driver.quit();
    }
}
