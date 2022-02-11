package com.solvd.practiceqa;

import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AbstractTest {

    protected static WebDriver driver;

    @BeforeTest
    public void beforeTests() {
        new ConfigService();
        driver = DriverService.driverInit();
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }
}
