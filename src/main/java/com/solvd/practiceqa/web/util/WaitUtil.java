package com.solvd.practiceqa.web.util;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class WaitUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Long explicitTimeout = Long.parseLong(ConfigService.getValue(ConfigData.EXPLICIT_TIMEOUT));

    public static void waitVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTimeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LOGGER.warn("Thread was interrupted");
        }
    }
}
