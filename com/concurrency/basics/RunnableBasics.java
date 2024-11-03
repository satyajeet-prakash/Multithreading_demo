package com.concurrency.basics;

public class RunnableBasics {
    public static void main(String[] args) {
        CustomRunnableThread runnableThread = new CustomRunnableThread();
        Thread rt1 = new Thread(runnableThread);
        rt1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread finished.");
    }
}

class CustomRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread finished.");
    }
}
