package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaozhirong on 2019/4/10.
 */
public class LockTest {

    private static  Integer goods = 10000;


    static ReentrantLock reentrantLock = new ReentrantLock();

    static RedissonClient redissonClient;

    static {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        redissonClient = Redisson.create(config);
    }


    public static void saleLockForRedisson(){
        RLock lock = redissonClient.getLock("sale");
        try {
            lock.lock();
            LockTest.goods--;
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void saleLockReentrantLock(){
        reentrantLock.lock();
        try {
                LockTest.goods--;
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }

    public static void sale(){
        try {
            LockTest.goods--;
        }catch (Exception e){

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 1000;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatchStart = new CountDownLatch(1);
        CountDownLatch countDownLatchEnd = new CountDownLatch(threadNum);
        for (int i =0 ; i < threadNum; i++){
            executorService.submit(new Run(countDownLatchStart,countDownLatchEnd));
        }
        countDownLatchStart.countDown();
        countDownLatchEnd.await();
        System.out.println("===================="+LockTest.goods);
    }
}


