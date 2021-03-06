package com.concurrent.sample.unisexBathroom;

public class UnisexBathroom {

    private static final String NONE = "none";
    private static final String MEN = "men";
    private static final String WOMEN = "women";

    private String inUse = NONE;

    private int peopleUsing = 0;

    private void useBathroom() {
        System.out.println("Using bathroom " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Exiting bathroom " + Thread.currentThread().getName());
    }

    public void menUse() throws InterruptedException {

        synchronized (this) {

            while (inUse.equals(WOMEN)) {
                wait();
            }

            inUse = MEN;
            peopleUsing++;

        }

        useBathroom();

        synchronized (this) {

            peopleUsing--;

            if (peopleUsing == 0) {
                inUse = NONE;
            }

            notifyAll();

        }

    }

    public void womenUse() throws InterruptedException {

        synchronized (this) {

            while (inUse.equals(MEN)) {
                wait();
            }

            inUse = WOMEN;
            peopleUsing++;

        }

        useBathroom();

        synchronized (this) {

            peopleUsing--;

            if (peopleUsing == 0) {
                inUse = NONE;
            }

            notifyAll();

        }

    }

}
