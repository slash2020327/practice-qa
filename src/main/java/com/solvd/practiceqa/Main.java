package com.solvd.practiceqa;

import com.solvd.practiceqa.threads.ThreadTest;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream.range(0, 7)
                .boxed()
                .forEach(index -> {
                    ThreadTest threadTest = new ThreadTest();
                    threadTest.start();
                    threadTest.sleep(500);
                });
    }
}
