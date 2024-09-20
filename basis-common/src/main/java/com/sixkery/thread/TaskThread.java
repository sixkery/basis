package com.sixkery.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sixkery
 * @since 2023/6/13
 */
public class TaskThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建一个容量为 5 的线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 提交任务，由线程池中空闲的线程执行
            executorService.execute(new Task(i));
        }
    }

    static class Task implements Runnable {
        private final int taskNum;

        public Task(int i) {
            this.taskNum = i;

        }

        @Override
        public void run() {
            // 线程池中的线程会调用该方法进行具体任务的执行
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.sleep(1000); // 模拟任务耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + " 执行完毕");


        }
    }

}
