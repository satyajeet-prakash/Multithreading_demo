package com.concurrency.lifecycle;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

public class ThreadLifeCycle {

    Queue<String> queue = new LinkedList<>();
    int capacity = 0;

    public static void main(String[] args) {
        ThreadLifeCycle lifeCycleObj = new ThreadLifeCycle();
        ProducerThread producerObj = new ProducerThread(lifeCycleObj);

        Thread producer = new Thread(producerObj);

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    lifeCycleObj.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread finished.");
    }

    public synchronized void produce() throws InterruptedException {
        while (true) {
            if(3 == capacity) {
                wait();
            }
            System.out.println("Message send: " + Thread.currentThread().getName());
            queue.add(Thread.currentThread().getName());
            notify();
            capacity++;
        }
    }

    public synchronized void consume() throws InterruptedException {
        while(true) {
            if(0 == capacity || queue.isEmpty()) {
                wait();
            }
            System.out.println("Consumed message: " + queue.poll());
            capacity--;
            notify();
            Thread.sleep(1000);
        }
    }
}
