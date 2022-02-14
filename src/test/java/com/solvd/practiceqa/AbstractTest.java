package com.solvd.practiceqa;

import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.TestDataService;
import com.solvd.practiceqa.web.util.DriverUtil;
import org.testng.annotations.*;

public abstract class AbstractTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigService.createInstance();
        TestDataService.createInstance();
    }

    @AfterTest
    public void afterTests() {
        DriverUtil.releaseDrivers();
    }
}
