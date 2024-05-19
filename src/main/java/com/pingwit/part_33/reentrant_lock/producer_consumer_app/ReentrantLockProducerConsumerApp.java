package com.pingwit.part_33.reentrant_lock.producer_consumer_app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ReentrantLockProducerConsumerApp {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(producer);
        executorService.execute(consumer);

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("Total delivered: " + store.getTotalDelivered());
        System.out.println("Total sold: " + store.getTotalSold());
    }
}
