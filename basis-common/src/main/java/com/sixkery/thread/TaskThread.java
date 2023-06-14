package com.sixkery.thread;

/**
 * @author sixkery
 * @since 2023/6/13
 */
public class TaskThread extends Thread {


    @Override
    public void run() {
        System.out.println("true = " + true);
    }


    public static void main(String[] args) {
        TaskThread taskThread = new TaskThread();
        // 启动一个新的线程
        taskThread.start();

    }
}
