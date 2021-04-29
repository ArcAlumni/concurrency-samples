package com.concurrent.sample.semaphores;

public class CountingSemaphore {

    private int maxPermits;
    private int allowedPermits;

    public CountingSemaphore(int maxPermits) {
        this.maxPermits = maxPermits;
    }

    public synchronized void acquire() {

        while (allowedPermits == maxPermits) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        allowedPermits++;
        notifyAll();

    }

    public synchronized void release() {

        while (allowedPermits == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        allowedPermits--;
        notifyAll();

    }

}
