package com.solvd.practiceqa.web.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverUtil {

    public static ConcurrentHashMap<String, WebDriver> drivers = new ConcurrentHashMap<>();

    public static WebDriver getDriver(String name) {
        ChromeDriver driver = new ChromeDriver();
        drivers.put(name, driver);
        return driver;
    }

    public static WebDriver getOptionsDriver(String name, ChromeOptions options) {
        ChromeDriver driver = new ChromeDriver(options);
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

    public static WebDriver getDriverByName(String name) {
        WebDriver driver = null;
        for (Map.Entry<String, WebDriver> entry : drivers.entrySet()) {
            if (name.equals(entry.getKey())) {
                driver = entry.getValue();
            }
        }
        return driver;
    }
}
