package com.concurrent.sample.barrier;

public class Barrier {

    private int totalCount;

    private int threadCount;

    private int threadsReleased = 0;

    public Barrier(int count) {
        this.totalCount = count;
    }

    public synchronized void await() throws InterruptedException {

        while (threadCount == totalCount) {
            wait(); // you are here so early, so wait here
        }

        threadCount++;

        if (threadCount == totalCount) {
            notifyAll(); // you are the last one, so notify waiting threads
            threadsReleased = totalCount;
        } else {
            while (threadCount < totalCount) // to handle of spurious wakeups
                wait(); // if you are not the last one wait here until the last one notifies you
        }

        threadsReleased--;
        if (threadsReleased == 0) { // reinitialize barrier to reuse the same object
            threadCount = 0;
            notifyAll(); // all done. notify the early threads
        }
    }

}
