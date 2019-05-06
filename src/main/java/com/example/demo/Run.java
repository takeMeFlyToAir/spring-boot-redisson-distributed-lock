package com.example.demo;

import java.util.concurrent.CountDownLatch;

class Run implements Runnable{

    private final CountDownLatch countDownLatchStart;
    private final CountDownLatch countDownLatchEnd;


    public Run(CountDownLatch countDownLatchStart, CountDownLatch countDownLatchEnd) {
        this.countDownLatchStart = countDownLatchStart;
        this.countDownLatchEnd = countDownLatchEnd;
    }

    @Override
    public void run() {
        try {
            countDownLatchStart.await();
            LockTest.sale();
            countDownLatchEnd.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}