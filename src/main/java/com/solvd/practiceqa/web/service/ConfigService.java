package com.solvd.practiceqa.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class ConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static String BASE_URL;
    public static String BROWSER;

    public ConfigService() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            LOGGER.warn("Property file can't be read");
        }
        BASE_URL = property.getProperty("base_url");
        BROWSER = property.getProperty("browser");
    }
}
