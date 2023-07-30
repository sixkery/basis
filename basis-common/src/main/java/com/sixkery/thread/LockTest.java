package com.sixkery.thread;

import org.springframework.util.StopWatch;

/**
 * @author sixkery
 * @since 2023/7/30
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        IncreaseDto increaseDto = new IncreaseDto();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increaseDto.increase();
            }
        });
        t1.start();
        for (int i = 0; i < 10000; i++) {
            increaseDto.increase();
        }
        t1.join();
        System.out.println("t1 = " + stopWatch.getTotalTimeMillis());


    }
}
