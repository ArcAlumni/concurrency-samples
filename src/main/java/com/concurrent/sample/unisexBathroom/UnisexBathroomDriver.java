package com.concurrent.sample.unisexBathroom;

public class UnisexBathroomDriver {

    public static void main(String[] args) throws InterruptedException {

        UnisexBathroomLimited bathroom = new UnisexBathroomLimited();

        Thread female1 = new Thread(() -> {
            try {
                bathroom.womenUse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "female1");

        Thread female2 = new Thread(() -> {
            try {
                bathroom.womenUse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "female2");

        Thread male1 = new Thread(() -> {
            try {
                bathroom.menUse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "male1");

        Thread male2 = new Thread(() -> {
            try {
                bathroom.menUse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "male2");

        Thread male3 = new Thread(() -> {
            try {
                bathroom.menUse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
