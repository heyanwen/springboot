package com.lemon.controller;

import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable {

    static ReentrantLock lock = new ReentrantLock(true);

    static int a = 0;

    public static void main(String[] args) throws InterruptedException {

        /**
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();

        lock.unlock();

        Test t1 = new Test();
        Thread thread1 = new Thread(t1);
        thread1.start();
        //thread1.join();
        System.out.println(a);
        Test t2 = new Test();
        Thread thread2 = new Thread(t2);
        thread2.start();
        //thread2.join();
        System.out.println(a);
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){

            System.out.println(Thread.currentThread().getId()+"线程把"+a+"变为"+(a+1));
            a++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
