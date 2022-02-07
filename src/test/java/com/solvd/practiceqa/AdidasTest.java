package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdidasTest {

    private static WebDriver driver;

    @BeforeTest public void before() {
        driver = new SafariDriver();
    }

    @Test public void loginTest() {
        String email = "testingsolvd@gmail.com";
        String pass = "pewdoc-cuqzi0-ciHzib";
        LoginPage lp = new LoginPage(driver);
        sleep(3);
        AccountPage accountPage = lp.login(email, pass);
        sleep(4);
        Assert.assertTrue(accountPage.getTitle().isDisplayed());
    }

    @AfterTest public void after() {
        driver.quit();
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
