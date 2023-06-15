package com.sixkery.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sixkery
 * @since 2023/6/13
 */
public class TaskThread implements Runnable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new TaskThread());
    }

    @Override
    public void run() {
        System.out.println("true = " + true);
    }
}
