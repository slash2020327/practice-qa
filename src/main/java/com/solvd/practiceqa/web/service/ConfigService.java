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

public class ConfigService {

    private static ConfigService instance;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static Map<String, String> configData;

    private ConfigService() {
        configData = new HashMap<>();
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/_config.properties");
            property.load(fis);
            Set<String> configPropertyNames = property.stringPropertyNames();
            configPropertyNames
                    .forEach(name -> configData.put(name, property.getProperty(name)));
        } catch (IOException e) {
            LOGGER.warn("Property file can't be read");
        }
    }

    public static String getValue(ConfigData property) {
        String value = null;
        for (String key : configData.keySet()) {
            if (key.equals(property.getTitle())) {
                value = configData.get(key);
            }
        }
        return value;
    }

    public static String getValue(String property) {
        String value = null;
        for (String key : configData.keySet()) {
            if (key.equals(property)) {
                value = configData.get(key);
            }
        }
        return value;
    }

    public static ConfigService createInstance() {
        if (instance == null) {
            instance = new ConfigService();
        }
        return instance;
    }
}
