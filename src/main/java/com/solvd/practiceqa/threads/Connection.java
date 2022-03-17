package com.solvd.practiceqa.threads;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Connection {

    private Integer name;
    public static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public Connection(Integer name) {
        this.name = name;
    }

    public void createConnection() {
        LOGGER.info("The connection " + name + " was created");
        sleep(500);
    }

    public void readConnection() {
        LOGGER.info("The connection was read");
        sleep(500);
    }

    public void updateConnection() {
        LOGGER.info("The connection was updated");
        sleep(500);
    }

    public void deleteConnection() {
        LOGGER.info("The connection was deleted");
        sleep(500);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}
