package com.concurrent.sample.readersWriter;

public class ReadWriteLockDriver {

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLock lock = new ReadWriteLock();

        Thread writer1 = new Thread(() -> {
            lock.acquireWriteLock();
            try {
                System.out.println("Writer-1 writing");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            lock.releaseWriteLock();
        });

        Thread writer2 = new Thread(() -> {
            lock.acquireWriteLock();
            try {
                System.out.println("Writer-2 writing");
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            lock.releaseWriteLock();
        });

        Thread reader1 = new Thread(() -> {
            lock.acquireReadLock();
            try {
                System.out.println("Reader-1 reading");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            lock.releaseReadLock();
        });

        Thread reader2 = new Thread(() -> {
            lock.acquireReadLock();
            try {
                System.out.println("Reader-2 reading");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            lock.releaseReadLock();
        });

        reader1.start();
        reader2.start();

        writer1.start();
        writer2.start();

        reader1.join();
        reader2.join();
        writer1.join();
        writer2.join();

    }

}
