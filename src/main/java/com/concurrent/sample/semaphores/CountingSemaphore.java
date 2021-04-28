package com.concurrent.sample.semaphores;

public class CountingSemaphore {

    private int maxPermits;
    private int allowedPermits;

    public CountingSemaphore(int maxPermits) {
        this.maxPermits = maxPermits;
    }

    public synchronized void acquire() {

        try {
            while (allowedPermits == maxPermits) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allowedPermits++;
        notifyAll();

    }

    public synchronized void release() {

        try {
            while (allowedPermits == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allowedPermits--;
        notifyAll();

    }

}
