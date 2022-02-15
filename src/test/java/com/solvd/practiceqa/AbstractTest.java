package com.solvd.practiceqa;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.annotations.*;

public abstract class AbstractTest implements IAbstractTest {

    @BeforeSuite
    public void beforeSuite() {
        ConfigService.createInstance();
        TestDataService.createInstance();
    }
}
