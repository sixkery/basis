package com.sixkery.thread;

import java.io.IOException;

/**
 * @author sixkery
 * @since 2023/7/30
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException, IOException {


        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("在50秒之内按任意键中断线程!");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出!");



    }
}
