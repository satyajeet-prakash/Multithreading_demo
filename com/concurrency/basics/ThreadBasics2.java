package com.concurrency.basics;

public class ThreadBasics2 {
    public static void main(String[] args) {
        Thread th = new Thread(ThreadPlay::doSomething);
        th.start();
        th.interrupt(); // Thread will be shutdown instantly and throws Exception
        System.out.println(Thread.currentThread().getName() + " thread finished.");
    }
}

class ThreadPlay {
    public static void doSomething() {
        System.out.println(Thread.currentThread().getName() + " invoked ThreadPlay.doSomething()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " completed ThreadPlay.doSomething()");
    }
}
