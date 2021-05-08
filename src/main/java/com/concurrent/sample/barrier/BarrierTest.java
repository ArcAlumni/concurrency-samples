package com.concurrent.sample.barrier;

public class BarrierTest {

    public static void main(String[] args) throws InterruptedException {

        Barrier barrier = new Barrier(3);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("T1 await");
                barrier.await();
                Thread.sleep(1000);
                System.out.println("T1 await");
                barrier.await();
                Thread.sleep(1000);
                System.out.println("T1 await");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("T2 await");
                barrier.await();
                Thread.sleep(300);
                System.out.println("T2 await");
                barrier.await();
                Thread.sleep(400);
                System.out.println("T2 await");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("T3 await");
                barrier.await();
                Thread.sleep(600);
                System.out.println("T3 await");
                barrier.await();
                Thread.sleep(200);
                System.out.println("T3 await");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }

}
