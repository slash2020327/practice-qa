package com.solvd.practiceqa;

import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.DriverService;
import com.solvd.practiceqa.web.service.TestDataService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class AbstractTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        ConfigService.createInstance();
        TestDataService.createInstance();
    }

    @BeforeTest
    public void beforeTests() {
        driver = DriverService.driverInit();
    }

    @AfterTest
    public void afterTests() {
        driver.quit();
    }
}
