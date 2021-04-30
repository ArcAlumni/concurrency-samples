package com.concurrent.sample.unisexBathroom;

public class UnisexBathroomDriver {

    public static void main(String[] args) throws InterruptedException {

        UnisexBathroom bathroom = new UnisexBathroom();

        Thread female1 = new Thread(() -> {
            bathroom.womenUse();
        }, "female1");

        Thread female2 = new Thread(() -> {
            bathroom.womenUse();
        }, "female2");

        Thread male1 = new Thread(() -> {
            bathroom.menUse();
        }, "male1");

        Thread male2 = new Thread(() -> {
            bathroom.menUse();
        }, "male2");

        Thread male3 = new Thread(() -> {
            bathroom.menUse();
        }, "male3");

        female1.start();
        female2.start();

        male1.start();
        male2.start();
        male3.start();

        female1.join();
        female2.join();

        male1.join();
        male2.join();
        male3.join();

    }

}
