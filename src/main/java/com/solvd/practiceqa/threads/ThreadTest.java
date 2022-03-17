package com.solvd.practiceqa.threads;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        ConnectionPool cp = ConnectionPool.getInstance(5);
        Connection connection;
        connection = cp.getConnection();
        connection.createConnection();
        connection.readConnection();
        cp.releaseConnection(connection);
    }
}
