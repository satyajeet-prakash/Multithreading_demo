package com.concurrency.baics;

public class ThreadBasics {
    public static void main(String[] args) {
        CustomThread t1 = new CustomThread();
        t1.start();
        System.out.println(Thread.currentThread().getName() + " thread ended.");
    }
}

class CustomThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread ended.");
    }
}
