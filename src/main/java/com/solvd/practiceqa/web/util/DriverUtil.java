package com.solvd.practiceqa.web.util;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static ConcurrentHashMap<String, WebDriver> drivers = new ConcurrentHashMap<>();

    public static WebDriver getDriver(String name) {
        WebDriver driver = null;
        for (Map.Entry<String, WebDriver> entry : drivers.entrySet()) {
            if (name.equals(entry.getKey())) {
                driver = entry.getValue();
            }
        }
        if (driver == null) {
            driver = initDriver();
            drivers.put(name, driver);
        }
        return driver;
    }

    public static WebDriver getOptionsDriver(String name, DesiredCapabilities capabilities) {
        WebDriver driver;
        driver = initDriverCapabilities(capabilities);
        drivers.put(name, driver);
        return driver;
    }

    public static void releaseDriver(WebDriver driver) {
        for (Map.Entry<String, WebDriver> entry : drivers.entrySet()) {
            if (driver.equals(entry.getValue())) {
                entry.getValue().quit();
                drivers.remove(entry.getKey());
            }
        }
    }

    public static void releaseDrivers() {
        for (Map.Entry<String, WebDriver> entry : drivers.entrySet()) {
            entry.getValue().quit();
            drivers.remove(entry.getKey());
        }
    }

    private static WebDriver initDriver() {
        String browser = ConfigService.getValue(ConfigData.BROWSER);
        WebDriver driver = null;
        switch (browser) {
        case "chrome":
            driver = new ChromeDriver();
            break;
        case "safari":
            driver = new SafariDriver();
            break;
        case "firefox":
            driver = new FirefoxDriver();
        default:
            LOGGER.warn("Browser is not defined");
        }
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initDriverCapabilities(DesiredCapabilities capabilities) {
        String browser = ConfigService.getValue(ConfigData.BROWSER);
        WebDriver driver = null;
        switch (browser) {
        case "chrome":
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(capabilities);
            driver = new ChromeDriver(chromeOptions);
            break;
        case "safari":
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.merge(capabilities);
            driver = new SafariDriver();
            break;
        case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.merge(capabilities);
            driver = new FirefoxDriver();
        default:
            LOGGER.warn("Browser is not defined");
        }
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }
}
