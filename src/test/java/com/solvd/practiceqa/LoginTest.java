package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.LoginService;
import com.solvd.practiceqa.web.service.PageService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private static WebDriver driver;
    private static PageService pageService;

    @BeforeTest public void before() {
        new LoginService();
        new ConfigService();
        driver = PageService.driverInit();
        pageService = new PageService(driver);
    }

    @Test public void loginTest() {
        String email = LoginService.EMAIL;
        String pass = LoginService.PASSWORD;
        AccountPage accountPage = pageService.login(email, pass);
        pageService.sleep(5);
        Assert.assertTrue(accountPage.getTitle().isDisplayed(), "Account page is not opened");
    }

    @AfterTest public void after() {
        driver.quit();
    }
}
