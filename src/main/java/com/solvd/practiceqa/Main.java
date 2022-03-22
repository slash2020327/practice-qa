package com.solvd.practiceqa;

import com.solvd.practiceqa.threads.ThreadTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        IntStream.range(0, 10).boxed()
                .forEach(index -> {
                    ThreadTest threadTest = new ThreadTest();
                    threadTest.start();
                    threads.add(threadTest);
                });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.warn("Thread was interrupted");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadTest runnableCheck = new ThreadTest();
        List<CompletableFuture<Void>> futureList = IntStream.range(0, 10)
                .boxed()
                .map(integer -> CompletableFuture.runAsync(runnableCheck, executorService))
                .collect(Collectors.toList());

        CompletableFuture<Void> futureFutures =
                CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        try {
            futureFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.warn("Thread was interrupted");
        }
        LOGGER.info("All CompletableFutures executed");
        executorService.shutdown();
    }
}
