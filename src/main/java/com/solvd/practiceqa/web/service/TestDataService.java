package com.solvd.practiceqa.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestDataService {

    private static TestDataService instance;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static Map<String, String> testData;

    private TestDataService() {
        testData = new HashMap<>();
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/login.properties");
            property.load(fis);
            Set<String> loginPropertyNames = property.stringPropertyNames();
            loginPropertyNames
                    .forEach(name -> testData.put(name, property.getProperty(name)));

            fis = new FileInputStream("src/test/resources/product.properties");
            property.load(fis);
            Set<String> productPropertyNames = property.stringPropertyNames();
            productPropertyNames
                    .forEach(name -> testData.put(name, property.getProperty(name)));
        } catch (IOException e) {
            LOGGER.warn("Property file can't be read");
        }
    }

    public static String getValue(String property) {
        String value = null;
        for (String key : testData.keySet()) {
            if (key.equals(property)) {
                value = testData.get(key);
            }
        }
        return value;
    }

    public static void createInstance() {
        if (instance == null) {
            instance = new TestDataService();
        }
    }
}
