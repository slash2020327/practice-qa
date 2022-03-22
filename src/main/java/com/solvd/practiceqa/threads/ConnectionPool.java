package com.solvd.practiceqa.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private volatile static ConnectionPool instance;
    private volatile static int freeConnections;
    private final Queue<Connection> activeConnections;

    private ConnectionPool(int sizeOfPool) {
        freeConnections = sizeOfPool;
        this.activeConnections = new ConcurrentLinkedQueue<>();
    }

    public Connection getConnection() {
        synchronized (activeConnections) {
            if (freeConnections != 0) {
                this.activeConnections.offer(new Connection(freeConnections));
                freeConnections--;
            }
            while (activeConnections.isEmpty()) {
                try {
                    activeConnections.wait();
                } catch (InterruptedException e) {
                    LOGGER.warn("Can't wait for free Connection");
                }
            }
            return activeConnections.poll();
        }
    }

    public void releaseConnection(Connection task) {
        synchronized (this.activeConnections) {
            this.activeConnections.offer(task);
            this.activeConnections.notify();
        }
    }

    public static ConnectionPool getInstance(int sizeOfPool) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(sizeOfPool);
                }
            }
        }
        return instance;
    }
}
