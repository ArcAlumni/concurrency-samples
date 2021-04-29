package com.concurrent.sample.boundedbuffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue {

    private int capacity;

    private Queue<Integer> queue;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>(capacity);
    }

    public void add(int v) {

        synchronized (this) {

            while (queue.size() == capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }

            queue.add(v);
            notifyAll();

        }

    }

    public int poll() {

        int v = -1;

        synchronized (this) {

            while (queue.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }

            v = queue.poll();
            notifyAll();

        }

        return v;
    }

}
