package com.concurrency.lifecycle;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerThread implements Runnable {

    private ThreadLifeCycle lifeCycleObj;

    public ProducerThread(ThreadLifeCycle lifeCycleObj) {
        this.lifeCycleObj = lifeCycleObj;
    }

    @Override
    public void run() {
        try {
            lifeCycleObj.produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
