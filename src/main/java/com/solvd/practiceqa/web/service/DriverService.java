package com.solvd.practiceqa.web.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class DriverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static WebDriver driverInit() {
        String browser = ConfigService.getValue(ConfigData.BROWSER);
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
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }
}
