package com.solvd.practiceqa.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static String EMAIL;
    public static String PASSWORD;

    public LoginService() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/login.properties");
            property.load(fis);
        } catch (IOException e) {
            LOGGER.warn("Property file can't be read");
        }
        EMAIL = property.getProperty("email");
        PASSWORD = property.getProperty("password");
    }
}
