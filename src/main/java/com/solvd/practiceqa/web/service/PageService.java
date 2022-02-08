package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AccountPage;
import com.solvd.practiceqa.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class PageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public PageService(WebDriver driver) {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    public AccountPage login(String email, String pass) {
        loginPage.open();
        sleep(4);
        loginPage.printEmail(email);
        loginPage.printPassword(pass);
        loginPage.getLoginButton().click();
        return accountPage;
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LOGGER.warn("Thread was interrupted");
        }
    }

    public static WebDriver driverInit() {
        String browser = ConfigService.BROWSER;
        WebDriver driver = null;
        switch (browser) {
        case "chrome":
            driver = new ChromeDriver();
            break;
        case "safari":
            driver = new SafariDriver();
            break;
        default:
            LOGGER.warn("Browser is not defined");
        }
        return driver;
    }
}
