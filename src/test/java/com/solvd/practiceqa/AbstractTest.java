package com.solvd.practiceqa;

import com.nordstrom.automation.testng.LinkedListeners;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.listeners.CarinaListener;
import com.qaprosoft.carina.core.foundation.listeners.CarinaListenerChain;
import com.qaprosoft.carina.core.foundation.listeners.FilterTestsListener;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.TestDataService;
import com.zebrunner.agent.testng.listener.TestRunListener;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.annotations.ListenersAnnotation;

@LinkedListeners({ CarinaListener.class, TestRunListener.class, FilterTestsListener.class })
public abstract class AbstractTest implements IAbstractTest {

    protected ListenersAnnotation listenersAnnotation;
    protected CarinaListenerChain listener;

    @BeforeSuite
    public void beforeSuite() {
        ConfigService.createInstance();
        TestDataService.createInstance();
        listenersAnnotation = new ListenersAnnotation();
        listener = new CarinaListenerChain();
        listener.transform(listenersAnnotation, AbstractTest.class);
    }
}
