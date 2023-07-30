package com.sixkery.response;

/**
 * @author sixkery
 * @since 2023/7/30
 */
class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("args = " + args);
        });
        System.out.println("state = " + t1.getState()); // NEW

        Thread t2 = new Thread(() -> {
            while (true) {
            }
        });
        t2.start();
        Thread.sleep(500);
        System.out.println("state = " + t2.getState()); // RUNNABLE


        final Object obj = new Object();

        Thread t3 = new Thread(() -> {
            // t3 拿不到锁资源，导致变为 blocked 状态
            synchronized (obj) {
            }
        });
        // main 线程拿到锁资源
        synchronized (obj) {
            t3.start();
            Thread.sleep(500);
            System.out.println("state = " + t3.getState()); // BLOCKED
        }

        Thread t4 = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
            t3.start();
            Thread.sleep(500);
            System.out.println("state = " + t4.getState()); // wating


        Thread t5 = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        Thread.sleep(500);
        System.out.println("state = " + t5.getState()); // timed_waiting

    }


}
