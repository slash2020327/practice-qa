package com.solvd.practiceqa.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ThreadTest extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void run() {
        Connection connection = ConnectionPool.getConnection();
        connection.createConnection();
        connection.readConnection();
        ConnectionPool.releaseConnection(connection);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            LOGGER.warn("Thread was interrupted");
        }
    }
}
