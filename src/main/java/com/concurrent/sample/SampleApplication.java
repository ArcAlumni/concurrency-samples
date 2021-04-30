package com.concurrent.sample;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}

}
