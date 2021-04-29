package com.concurrent.sample.readersWriter;

public class ReadWriteLock {

    boolean writeLocked;

    int readers = 0;

    public synchronized void acquireReadLock() {

        while (writeLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        readers++;

    }

    public synchronized void releaseReadLock() {

        readers--;
        notifyAll();

    }

    public synchronized void acquireWriteLock() {

        while (writeLocked || readers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        writeLocked = true;

    }

    public synchronized void releaseWriteLock() {

        writeLocked = false;
        notifyAll();

    }

}
