package com.solvd.practiceqa.web.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverUtil {

    public static ConcurrentHashMap<Integer, WebDriver> drivers = new ConcurrentHashMap<>();

    public static WebDriver getDriver() {
        ChromeDriver driver = new ChromeDriver();
        drivers.put(driver.hashCode(), driver);
        return driver;
    }

    public static WebDriver getIncognitoDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        ChromeDriver driver = new ChromeDriver(options);
        drivers.put(driver.hashCode(), driver);
        return driver;
    }

    public static WebDriver getOptionsDriver(ChromeOptions options) {
        ChromeDriver driver = new ChromeDriver(options);
        drivers.put(driver.hashCode(), driver);
        return driver;
    }

    public static void releaseDriver(WebDriver driver) {
        for (Map.Entry<Integer, WebDriver> entry : drivers.entrySet()) {
            if (entry.getValue().equals(driver)) {
                entry.getValue().quit();
                drivers.remove(entry.getKey());
            }
        }
    }

    public static void releaseDrivers() {
        for (Map.Entry<Integer, WebDriver> entry : drivers.entrySet()) {
            entry.getValue().quit();
            drivers.remove(entry.getKey());
        }
    }
}
