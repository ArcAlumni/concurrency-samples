package com.concurrent.sample.boundedbuffer;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueDriver {

    public static void main(String[] args) {

        AtomicInteger aInt = new AtomicInteger();

        BlockingQueue blockingQueue = new BlockingQueue(5);

        final int count = 20;

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= count; i++) {
                try {
                    System.out.println("Producer adding : " + i);
                    blockingQueue.add(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    int c = aInt.incrementAndGet();
                    if (c > count) {
                        break;
                    }
                    System.out.println("Polled consumer 1 : " + blockingQueue.poll());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    int c = aInt.incrementAndGet();
                    if (c > count) {
                        break;
                    }
                    System.out.println("Polled consumer 2 : " + blockingQueue.poll());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
