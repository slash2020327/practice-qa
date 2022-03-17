package com.solvd.practiceqa.threads;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class ConnectionPool {

    private static volatile ConnectionPool instance;

    private volatile List<Connection> freeConnections = new CopyOnWriteArrayList<>();
    private volatile List<Connection> waitConnections = new CopyOnWriteArrayList<>();
    private volatile List<Connection> usedConnections = new CopyOnWriteArrayList<>();

    public static ConnectionPool createInstance(Integer numberOfConnections) {
        if (instance == null) {
            instance = new ConnectionPool(numberOfConnections);
        }
        return instance;
    }

    private ConnectionPool(Integer numberOfConnections) {
        synchronized (ConnectionPool.class) {
            createConnection(numberOfConnections);
        }
    }

    public void createConnection(Integer numberOfConnections) {
        IntStream.range(0, numberOfConnections)
                .forEach(index -> freeConnections.add(new Connection(index)));
        IntStream.range(0, 2)
                .forEach(index -> waitConnections.add(new Connection(index)));
    }

    public Connection getConnection() {
        Connection connection = null;
        synchronized (ConnectionPool.class) {
            if (freeConnections != null) {
                connection = freeConnections
                        .remove(freeConnections.size() - 1);
                usedConnections.add(connection);
            } else if (waitConnections.size() <= 2) {
                connection = new Connection(waitConnections.size());
                waitConnections.add(connection);
            }
            return connection;
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (ConnectionPool.class) {
            freeConnections.add(connection);
            usedConnections.remove(connection);
        }
    }
}
