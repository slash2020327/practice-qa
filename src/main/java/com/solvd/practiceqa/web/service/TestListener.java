package com.solvd.practiceqa.web.service;

import com.qaprosoft.carina.core.foundation.listeners.CarinaListenerChain;
import com.solvd.practiceqa.threads.Connection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends CarinaListenerChain implements ITestListener {

    public static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public TestListener() {
        super();
    }

    @Override
    public void onStart(ISuite suite) {
        LOGGER.info("Suite " + suite.getName() + " was started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Suite " + context.getSuite().getName() + " was finished");
        LOGGER.info("Success tests: " + context.getPassedTests().size());
        LOGGER.info("Failed tests: " + context.getFailedTests().size());
        LOGGER.info("Skipped tests: " + context.getSkippedTests().size());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test method " + result.getName() + " started in "
                + result.getTestContext().getStartDate());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.warn("Test method " + result.getName() + " failed");
    }
}
